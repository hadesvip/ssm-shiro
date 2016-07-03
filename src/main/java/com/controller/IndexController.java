package com.controller;

import com.bean.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangyong on 2016/7/3.
 */
@RestController
public class IndexController {


    @RequestMapping("/")
    public User welcome(User user) {

        System.out.println(user);
    /*    User user = new User();
        user.setUserName("admin");
        user.setPassword("admin");*/

        return user;
    }
}
