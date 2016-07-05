package com.bean;

/**
 * 用户信息
 * Created by wangyong on 2016/7/1.
 */

public class User {

    //用户编号
    private int userId;

    //用户名
    private String userName;

    //用户密码
    private String userPassword;

    //是否锁住
    private int locked;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getLocked() {
        return locked;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }
}
