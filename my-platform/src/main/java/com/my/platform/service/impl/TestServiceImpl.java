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
     * 打印完整的报错堆栈信息
     *
     * @return 报错堆栈信息
     */
    @Override
    public void testException() {
        int[] arr1 = new int[1];
        int[] arr2 = {1,2,3,4,5};
        int[] arr3 = new int[] {1,2,3};
        System.out.println(arr1[2]);
    }
}
