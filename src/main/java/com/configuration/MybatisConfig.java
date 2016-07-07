package com.configuration;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.ClassPathMapperScanner;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by wangyong on 2016/7/3.
 */
@Configuration
@Import(DataSourceConfig.class)
@MapperScan("com.dao")
public class MybatisConfig {

    @Bean(name = "sqlSessionFactory")
    // @DependsOn("dataSource")
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);

        //mybatis配置
        Properties props = new Properties();
        props.setProperty("mapUnderscoreToCamelCase", "true");

        sqlSessionFactory.setConfigurationProperties(props);
        sqlSessionFactory.setTypeAliasesPackage("com.bean");

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] classPathResources = resolver.getResources("classpath:mapper/*.xml");
        sqlSessionFactory.setMapperLocations(classPathResources);

        return sqlSessionFactory;
    }


    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

  /*  @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.dao");
        return mapperScannerConfigurer;
    }*/

}
