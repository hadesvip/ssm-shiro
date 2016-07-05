package com.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by wangyong on 2016/6/30.
 */
@Configuration
@ComponentScan(basePackages = {"com.dao", "com.service", "com.configuration"},
        useDefaultFilters = false,
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Service.class, Repository.class, Configuration.class})})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {


}
