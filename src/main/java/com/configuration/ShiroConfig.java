package com.configuration;

import com.component.ShiroRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro 配置
 * Created by wangyong on 2016/7/3.
 */
@Configuration
@Import(AppConfig.class)
public class ShiroConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShiroConfig.class);


    @Bean(name = "shiroRealm")
    public Realm realm() {
        ShiroRealm realm = new ShiroRealm();
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("MD5");
        matcher.setHashIterations(1024);
        realm.setCredentialsMatcher(matcher);

        return realm;
    }


    /**
     * 支持shiro表达式
     *
     * @return
     */
    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        LOGGER.info("register LifecycleBeanPostProcessor....");

        return new LifecycleBeanPostProcessor();
    }


    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        LOGGER.info("register  DefaultAdvisorAutoProxyCreator");

        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }


    @Bean(name = "securityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(Realm shiroRealm) {
        LOGGER.info("register DefaultWebSecurityManager...");

        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(shiroRealm);

        return defaultWebSecurityManager;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        LOGGER.info("register AuthorizationAttributeSourceAdvisor...");

        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);

        return authorizationAttributeSourceAdvisor;
    }


    /**
     * 加载权限资源
     *
     * @param shiroFilterFactoryBean
     */
    private void loadFilterChainDefinitionMap(ShiroFilterFactoryBean shiroFilterFactoryBean) {
        LOGGER.info("load loadFilterChainDefinitionMap");

        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

        //设置资源:登录，登出不需要做验证
        filterChainDefinitionMap.put("/static/login.html", "anon");
        filterChainDefinitionMap.put("/druid/*", "anon");
        filterChainDefinitionMap.put("/logout", "anon");
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/index", "authc");


        //从数据库加载


        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
    }


    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        LOGGER.info("load shiroFilterFactoryBean...");

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/static/login.html");
        shiroFilterFactoryBean.setSuccessUrl("/index");
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");

        //设置权限资源
        loadFilterChainDefinitionMap(shiroFilterFactoryBean);

        return shiroFilterFactoryBean;
    }


}
