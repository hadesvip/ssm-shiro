package com.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 参数
 * Created by wangyong on 2016/6/30.
 */
@Configuration
@PropertySource("classpath:app.properties")
public class PropertiesConfig {

    /*@Autowired
    public Environment environment;*/

   /* @Bean(name = "yamlProperties")
    public YamlPropertiesFactoryBean yamlPropertiesFactoryBean() {
        YamlPropertiesFactoryBean yamlPropertiesFactoryBean = new YamlPropertiesFactoryBean();
        yamlPropertiesFactoryBean.setResources(new PathResource("classpath:application.yml"));

        return yamlPropertiesFactoryBean;
    }*/
}

