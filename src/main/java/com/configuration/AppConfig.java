package com.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.mvc.Controller;

/**
 * Created by wangyong on 2016/6/30.
 */
@Configuration
/*@ComponentScan(basePackages = {"com"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class})})*/
@ComponentScan(basePackages ={"com"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {


}
