package com.zhiyou.exception;

/**
 * @Classname MyAuthException
 * @Date 2021/12/27 14:53
 */
//自定义异常类
public class MyAuthException extends RuntimeException {
    public MyAuthException(String message) {
        super(message);
    }
}