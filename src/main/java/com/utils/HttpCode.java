package com.utils;

/**
 * http响应码
 * Created by wangyong on 2016/7/17.
 */
public enum HttpCode {

    OK(200, "操作成功..."),

    FAIL(401, "操作过程发生未知错误..."),

    INVAILDPARAM(402, "参数异常"),

    USEREXIST(501, "用户已经注册"),

    ACCOUNTNAMENOTEXIST(502, "账号名不存在"),

    ACCOUNTPASSWORDERROR(503, "账号密码错误"),

    ACCOUNTLOCK(504, "账号被锁住");

    // 响应码
    int code;

    // 描述
    String desc;

    HttpCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
