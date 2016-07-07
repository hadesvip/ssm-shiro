package com.service;

import com.bean.Role;

import java.util.Set;

/**
 * Created by wangyong on 2016/7/7.
 */
public interface RoleService {

    /**
     * 获取所有的角色信息
     */
    Set<Role> getRoles();
}
