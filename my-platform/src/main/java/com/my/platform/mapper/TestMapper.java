package com.my.platform.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @description:
 * @author: Karl
 * @date: 2020/9/4
 */
@Mapper
public interface TestMapper {
    /**
     * 数据库插入测试（异常回滚）
     *
     * @param s
     */
    void testAdd(String s);
}
