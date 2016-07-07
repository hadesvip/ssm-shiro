package com.bean;

import org.apache.ibatis.type.Alias;

/**
 * Created by wangyong on 2016/7/5.
 */
@Alias("resource")
public class Resource {

    //资源编号
    private int resourceId;

    //资源类型
    private int resourceType;

    //资源名
    private String resourceName;

    //资源地址
    private String url;

    //父资源
    private Resource parent;

    //权限表达式
    private String permission;


    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getResourceType() {
        return resourceType;
    }

    public void setResourceType(int resourceType) {
        this.resourceType = resourceType;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Resource getParent() {
        return parent;
    }

    public void setParent(Resource parent) {
        this.parent = parent;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
