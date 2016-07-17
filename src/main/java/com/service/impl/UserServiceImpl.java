package com.service.impl;

import com.bean.User;
import com.dao.UserMapper;
import com.service.UserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangyong on 2016/7/4.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional(readOnly = true)
    @Override
    public User getUser(String username) {
        Map<String, Object> params = new HashMap<>();
        params.put("username", username);
        return userMapper.getUser(params);
    }

    @Transactional
    @Override
    public int saveUser(String username, String password) {
        int result = 0;
        try {
            User user = new User();
            user.setUserName(username);
            user.setUserPassword(getSlatPassword(username, password));
            result = userMapper.insertUser(user);
        } catch (RuntimeException e) {
            return result;
        }
        return result;
    }

    /**
     * 盐值加密后的密码
     *
     * @param username 用户名
     * @param password 密码
     * @return 盐值加密后的密码
     */
    private String getSlatPassword(String username, String password) {
        String hashAlgorithmName = "MD5";
        Object salt = ByteSource.Util.bytes(username);
        int hashIterations = 1024;
        Object simpleHash = new SimpleHash(hashAlgorithmName, password, salt, hashIterations);
        return simpleHash.toString();
    }

}
