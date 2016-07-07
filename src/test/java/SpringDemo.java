import com.bean.User;
import com.configuration.AppConfig;
import com.configuration.MybatisConfig;
import com.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

/**
 * Created by wangyong on 2016/6/30.
 */
/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@PropertySource("classpath:app.properties")*/
public class SpringDemo {

 /*   @Autowired
    private UserService userService;

    @Test
    public void test() {

        User user = userService.getUser("admin");

        System.out.println(user.getUserName());
    }*/


}
