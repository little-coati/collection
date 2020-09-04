package com.my.platform.service;

/**
 * @description:
 * @author: Karl
 * @date: 2020/8/3
 */
public interface TestService {
    /**
     * 测试全局捕捉异常信息
     *
     * @return 报错堆栈信息
     */
    void testException();

    /**
     * 测试异常回滚
     *
     * @param type 测试类型：0-方法内捕捉异常，1-未捕捉
     */
    void testRollBack(String type);
}
