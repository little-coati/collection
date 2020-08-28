package com.my.platform.service.impl;

import com.my.platform.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Zhou Lixiong
 * @date: 2020/8/3
 */
@Service
public class TestServiceImpl implements TestService {
    /**
     * 测试全局捕捉异常信息
     *
     * @return 报错堆栈信息
     */
    @Override
    public void testException() {

        //数组的三种声明方式
        int[] arr1 = new int[1];
        int[] arr2 = {1,2,3,4,5};
        int[] arr3 = new int[] {1,2,3};
        System.out.println(arr1[2]);
    }
}
