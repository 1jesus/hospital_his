package com.zhiyou.common;

/**
 * @Classname ResultObject
 * @Date 2021/12/23 20:26
 */
public class ResultObject {

    /**
     * 状态码
     * 2001: OK
     * 3001: 超时
     * 40001: 错误
     * --------------
     * 目前为了方便记忆,
     * 200 OK
     * 500 ERR
     */
    private int code; // 状态码
    private String message;

    /**
     * 用于后端向前端发送数据
     */
    private Object data;

    public ResultObject() {
    }

    public ResultObject(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultObject(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResultObject{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
