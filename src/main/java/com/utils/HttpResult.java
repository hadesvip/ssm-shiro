package com.utils;

/**
 * 响应体
 * Created by wangyong on 2016/7/4.
 */
public class HttpResult<T> {


    //状态码
    private HttpCode resultCode;

    //响应消息
    private String resultMsg;

    //响应对象
    private T data;

    public static <T> HttpResult<T> success() {
        HttpResult<T> result = new HttpResult<>();
        result.resultCode = HttpCode.OK;
        result.resultMsg = "操作成功...";
        return result;
    }

    public static <T> HttpResult<T> fail() {
        HttpResult<T> result = new HttpResult<>();
        result.resultCode = HttpCode.FAIL;
        result.resultMsg = "操作过程中发生错误...";
        return result;
    }


    public HttpCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(HttpCode resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
