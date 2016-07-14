package com.controller;

import com.utils.HttpResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangyong on 2016/7/4.
 */
@RestController
public class ShiroController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public HttpResult login(String username, String password) {
        HttpResult result = HttpResult.fail();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        final Subject subject = SecurityUtils.getSubject();
        boolean authenticated = subject.isAuthenticated();
        System.out.println("islogin-->" + authenticated);
        subject.login(token);
        result.setData("login success...");
        return result;
    }


    /**
     * 用户注册
     *
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public HttpResult register(String username, String password, String repassword) {
        HttpResult result = HttpResult.fail();

        //参数校验


        return result;
    }


    @RequestMapping("/logout")
    public HttpResult logout() {
        HttpResult result = new HttpResult();
        SecurityUtils.getSubject().logout();
        result.setData("logout success...");
        return result;
    }

}
