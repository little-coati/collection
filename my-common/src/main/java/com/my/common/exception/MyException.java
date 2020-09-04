package com.my.common.exception;

/**
 * @author: 周立雄
 * @version: v1.0
 * @description: 自定义异常
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