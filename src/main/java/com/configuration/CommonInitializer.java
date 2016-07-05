package com.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.*;
import java.util.EnumSet;

/**
 * Created by wangyong on 2016/7/3.
 */
/*@Order(1)
@Configuration*/
public class CommonInitializer {
//        implements WebApplicationInitializer {

/**
 * 启动设置
 *
 * @param servletContext
 * @throws ServletException
 */
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {

//        WebApplicationContext context = getContext();
//        servletContext.addListener(new ContextLoaderListener(context));


    /*    FilterRegistration.Dynamic shiroFilter = servletContext.addFilter("shiroFilter", new DelegatingFilterProxy());
        shiroFilter.setInitParameter("targetFilterLifecycle", "true");
        shiroFilter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class),true,"*//*");*/


//dispatcherServlet，默认会读取/WEB-INF/dispatcherServlet-servlet.xml配置文件
//        ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet("dispatcherServlet", new DispatcherServlet());
//        dispatcherServlet.setLoadOnStartup(1);
//        dispatcherServlet.addMapping("/");


//    }


//    private AnnotationConfigWebApplicationContext getContext() {
//        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//        //配置springmvc配置文件
//        //context.setConfigLocation("com");
//        return context;
//    }
}
