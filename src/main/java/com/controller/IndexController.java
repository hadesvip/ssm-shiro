package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wangyong on 2016/7/3.
 */
@Controller
public class IndexController {


    @RequestMapping("/")
    public String welcome() {

        System.out.println("index...");

        return "index";
    }
}
