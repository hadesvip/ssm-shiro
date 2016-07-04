package com.controller;

import com.utils.HttpResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangyong on 2016/7/4.
 */
@RestController
public class ShiroController {


    @RequestMapping("/login")
    public HttpResult login() {
        HttpResult result = new HttpResult();

        return result;
    }


}
