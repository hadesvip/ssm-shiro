package com.controller;

import com.service.UserService;
import com.utils.HttpCode;
import com.utils.HttpResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注册，登录，登出功能
 * Created by wangyong on 2016/7/4.
 */
@RestController
public class ShiroController {

    private final Logger LOGGER = LoggerFactory.getLogger(ShiroController.class);

    @Autowired
    private UserService userService;

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public HttpResult login(String username, String password) {
        HttpResult result = HttpResult.fail();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        final Subject subject = SecurityUtils.getSubject();
        boolean authenticated = subject.isAuthenticated();
        System.out.println("islogin-->" + authenticated);

        try {
            if (subject.isAuthenticated())
                subject.login(token);
        } catch (UnknownAccountException e) {
            result.setResultCode(HttpCode.ACCOUNTNAMENOTEXIST);
            result.setResultMsg("账号名不存在...");
            return result;
        } catch (IncorrectCredentialsException e) {
            result.setResultCode(HttpCode.ACCOUNTPASSWORDERROR);
            result.setResultMsg("账号名密码错误...");
            return result;
        } catch (LockedAccountException e) {
            result.setResultCode(HttpCode.ACCOUNTLOCK);
            result.setResultMsg("账号被锁住...");
            return result;
        } catch (AuthenticationException e) {
            return result;
        }
        result = HttpResult.success();
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
        if (username == null || "".equals(username)) {
            result.setResultCode(HttpCode.INVAILDPARAM);
            result.setResultMsg("用户名为必填参数...");
            return result;
        }
        if (password == null || "".equals(password)) {
            result.setResultCode(HttpCode.INVAILDPARAM);
            result.setResultMsg("密码为必填参数...");
            return result;
        }
        if (!password.equals(repassword)) {
            result.setResultCode(HttpCode.INVAILDPARAM);
            result.setResultMsg("两次输入的密码不一致...");
            return result;
        }

        //注册接口
        int saveResult = userService.saveUser(username, password);

        //注册失败
        if (saveResult == 0) {
            result.setResultCode(HttpCode.USEREXIST);
            result.setResultMsg("用户已经注册...");
            return result;
        }

        result = HttpResult.success();
        return result;
    }


    /**
     * 登出
     *
     * @return
     */
    @RequestMapping("/logout")
    public HttpResult logout() {
        HttpResult result = new HttpResult();
        SecurityUtils.getSubject().logout();
        result.setData("logout success...");
        return result;
    }


}
