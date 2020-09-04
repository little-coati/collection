package com.my.common.exception;

/**
 * @description: 自定义异常
 * @author: Karl
 * @date: 2020/8/28
 */
public class MyException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public MyException(String message) {
        super(message);
    }

    public MyException(Throwable cause) {
        super(cause);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }
}