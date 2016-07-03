package com.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by wangyong on 2016/6/30.
 */
@Configuration
@PropertySource({"classpath:app.properties"})
public class DataSourceConfig {

    /*@Autowired
    Environment environment;*/

  /*  @Autowired
    @Qualifier("yamlProperties")
    private Properties yamlProperties;*/

    @Value("${jdbc.driverClass}")
    private String driverClass;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.username}")
    private String userName;

    @Value("${jdbc.password}")
    private String password;

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();

        //设置参数
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setUrl(jdbcUrl);
        dataSource.setDriverClassName(driverClass);

        return dataSource;
    }


}
