package com.service.impl;

import com.bean.User;
import com.dao.UserMapper;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangyong on 2016/7/4.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(String username) {
        Map<String, Object> params = new HashMap<>();
        params.put("username", username);
        return userMapper.getUser(params);
    }
}
