package com.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * 配置参数
 * Created by wangyong on 2016/6/30.
 */
@Configuration
@PropertySource({"classpath:app.properties"})
public class PropertiesConfig {


    /**
     * 另一种方式加载配置文件中的参数
     */
    /*@Autowired
    Environment environment;*/

    /**
     * To resolve ${} in @Value
     *
     * @return
     */
    @Bean
    public PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }

    /*@Bean(name = "propertyPlaceholderConfigurer")
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
        propertyPlaceholderConfigurer.setLocation(new ClassPathResource("app.properties"));
        propertyPlaceholderConfigurer.setIgnoreResourceNotFound(true);
        propertyPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(false);
        return propertyPlaceholderConfigurer;

    }*/


}

