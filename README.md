## ssm-shiro
1. 总体框架
    - springmvc+mybatis+angualrjs+bootstrap+logback+mysql+shiro
    
## 文档参考    
1. spring 官方文档
    - http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle  
      
## 功能点
1. 注册
2. 登录     
      
### 注意点
1. 使用springTest进行测试
    - 如果出现java.lang.NoSuchMethodError: org.slf4j.spi.LocationAwareLogger.log错误
        * jar冲突，去除 gradle org.slf4j:jcl-over-slf4j:1.5.8就行了
    
2. MapperScannerConfigurer 注入过早导入失败(不是此原因)
    - 参考http://stackoverflow.com/questions/24643426/java-config-bean-not-autowired-in-other-configuration-class
 
3. 关于用gradle方式配置mybatis问题及解决方式(目前只发现两种方式)
    - 在gradle中配置参数
           解决:在gradle中设置参数：
              sourceSets {
                 main {
                 java {
                 srcDir 'src/main/java'
                 }
                 resources {
                 srcDirs = ['src/main/resources', 'src/main/java']
               include(['**/*.xml', '**/*.properties'])
                        }
                   }
              }
    - 转移mapper配置文件目录
         - 在resources中建立目录:resources/mapper/*.xml
         - 在mybatisConfig中的SqlSessionFactoryBean中添加如下代码
                  PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
                  Resource[] classPathResources = resolver.getResources("classpath:mapper.xml");
                  sqlSessionFactory.setMapperLocations(classPathResources);
    - 两种方式看自己选择:个人倾向于第二种

4. 关于@PropertySource,@value注解
    - @PropertySource是跟Environment搭配使用
    - @PropertySource，@value
        @Bean
        public PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
            return new PropertySourcesPlaceholderConfigurer();
        }
    - @Value跟PropertyPlaceholderConfigurer,@PropertySource搭配使用
    