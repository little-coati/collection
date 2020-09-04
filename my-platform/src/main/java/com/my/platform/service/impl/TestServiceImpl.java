package com.my.platform.service.impl;

import com.my.common.exception.MyException;
import com.my.platform.mapper.TestMapper;
import com.my.platform.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @author: Karl
 * @date: 2020/8/3
 */
@Slf4j
@Service
public class TestServiceImpl implements TestService {

    /**
     * 使用@Mapper这里自动注入会报红，但是不影响使用
     */
    @Autowired
    private TestMapper testMapper;

    /**
     * 测试全局捕捉异常信息
     *
     * @return 报错堆栈信息
     */
    @Override
    public void testException() {

        //数组的三种声明方式
        int[] arr1 = new int[1];
        int[] arr2 = {1, 2, 3, 4, 5};
        int[] arr3 = new int[]{1, 2, 3};
        System.out.println(arr1[2]);
    }

    /**
     * 测试异常回滚
     *
     * @param type 测试类型：0-方法内捕捉异常，1-未捕捉
     */
    @Transactional(rollbackFor = Throwable.class)
    @Override
    public void testRollBack(String type) {
        if (StringUtils.equals(type,"0")) {
            try {
                testMapper.testAdd("123");
                throw new MyException("测试异常回滚");
            } catch (Exception e) {
                log.error("捕捉异常,数据库插入操作不会回滚");
            }
        } else {
            testMapper.testAdd("456");
            throw new MyException("测试异常回滚");

            //方法内没捕捉异常，抛出异常会回滚对数据库的插入操作
        }
    }
}
