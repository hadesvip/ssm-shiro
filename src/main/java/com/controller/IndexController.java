package com.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wangyong on 2016/7/3.
 */
@Controller
public class IndexController {


    @RequestMapping("/index")
    public String welcome() {

        Subject subject = SecurityUtils.getSubject();
        System.out.println("index is login--->" + subject.isAuthenticated());

        System.out.println("index...");

        return "index";
    }
}
