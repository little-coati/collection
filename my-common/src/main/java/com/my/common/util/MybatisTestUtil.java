package com.my.common.util;

import java.util.Collection;
import java.util.Map;

/**
 * @description: mybatis的<if test = " ">标签中使用的非空判断工具类
 * 使用方式：<if test="@com.xxx.xxx.util.MybatisTsetUtil@isNotEmpty(obj)">
 * @author: singleDog
 * @date: 2020/7/20
 */
public class MybatisTestUtil {
    public static boolean isEmpty(Object o) {
        if (o == null) {
            return true;
        }
        if (o instanceof String) {
            return ((String) o).trim().length() == 0;
        } else if (o instanceof Collection) {
            return ((Collection) o).isEmpty();
        } else if (o instanceof Map) {
            return ((Map) o).isEmpty();
        } else if (o.getClass().isArray()) {
            return ((Object[]) o).length == 0;
        } else {
            return false;
        }
    }

    public static boolean isNotEmpty(Object o) {
        return !isEmpty(o);
    }
}
