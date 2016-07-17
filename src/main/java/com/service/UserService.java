package com.service;

import com.bean.User;

/**
 * Created by wangyong on 2016/7/4.
 */
public interface UserService {

    /**
     * 根据用户名获取用户
     *
     * @param username 用户名
     * @return
     */
    User getUser(String username);

    /**
     * 保存用户
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    int saveUser(String username, String password);

}
