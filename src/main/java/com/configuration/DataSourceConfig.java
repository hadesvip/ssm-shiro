package com.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by wangyong on 2016/6/30.
 */
@Configuration
//@PropertySource(value = {"classpath:app.properties"}, ignoreResourceNotFound = false)
@Import(PropertiesConfig.class)
public class DataSourceConfig {

    @Autowired
    Environment environment;

    @Value("${jdbc.driverClass}")
    public String driverClass;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.username}")
    private String userName;

    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.maxActive}")
    private int maxActive;

    @Value("${jdbc.initialSize}")
    private int initialSize;

    @Value("${jdbc.maxWait}")
    private int maxWait;

    @Value("${jdbc.minIdle}")
    private int minIdle;

    @Value("${jdbc.timeBetweenEvictionRunsMillis}")
    private long timeBetweenEvictionRunsMillis;

    @Value("${jdbc.minEvictableIdleTimeMillis}")
    private long minEvictableIdleTimeMillis;

    @Value("${jdbc.validationQuery}")
    private String validationQuery;

    @Value("${jdbc.testWhileIdle}")
    private String testWhileIdle;

    @Value("${jdbc.testOnBorrow}")
    private String testOnBorrow;

    @Value("${jdbc.testOnReturn}")
    private String testOnReturn;

    @Value("${jdbc.filters}")
    private String filters;

    @Bean
    //@DependsOn("propertyPlaceholderConfigurer")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();

        //设置参数
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setUrl(jdbcUrl);
        dataSource.setDriverClassName(driverClass);
        dataSource.setMaxActive(maxActive);
        dataSource.setInitialSize(initialSize);
        dataSource.setMaxWait(maxWait);
        dataSource.setMinIdle(minIdle);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setTestWhileIdle(Boolean.parseBoolean(testWhileIdle));
        dataSource.setTestOnBorrow(Boolean.parseBoolean(testOnBorrow));
        dataSource.setTestOnReturn(Boolean.parseBoolean(testOnReturn));
        try {
            dataSource.setFilters(filters);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dataSource;
    }

}
