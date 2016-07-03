import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

/**
 * Created by wangyong on 2016/6/30.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath:spring-beans.xml"})
//@ComponentScan(basePackageClasses ={AppConfig.class})
public class SpringDemo {

  /*  @Autowired
    public ApplicationContext applicationContext;

    @Autowired
    private Map<String, Object> yamlMap;

    @Test
    public void test() {
        Map<String, Object> enviroment = (Map<String, Object>) yamlMap.get("yamlMap");
        Map<String, Object> mysql = (Map<String, Object>) enviroment.get("mysql");
        Map<String, Object> jdbc = (Map<String, Object>) mysql.get("jdbc");
        String url = (String) jdbc.get("url");
        System.out.println(url);
    }*/


}
