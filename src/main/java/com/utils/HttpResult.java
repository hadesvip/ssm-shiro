package com.utils;

/**
 * 响应体
 * Created by wangyong on 2016/7/4.
 */
public class HttpResult<T> {


    //状态码
    private int resultCode;

    //响应消息
    private String resultMsg;

    //响应对象
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
