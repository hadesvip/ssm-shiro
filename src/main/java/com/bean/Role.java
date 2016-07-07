package com.bean;

import org.apache.ibatis.type.Alias;

/**
 * Created by wangyong on 2016/7/5.
 */
@Alias("role")
public class Role {

    //角色编号
    private int roleId;

    //角色名
    private String roleName;

    //是否可用
    private int available;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }
}
