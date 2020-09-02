package com.my.platform.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description: 验证工具类
 * @author: Karl
 * @date: 2020/9/2
 */
public class ValidatorUtil {
    private static final Pattern mobile_pattern = Pattern.compile("1\\d{10}");

    /**
     * 验证字符串是不是手机号
     *
     * @param src 字符串
     * @return 布尔值
     */
    public static boolean isMobile(String src) {
        if(StringUtils.isEmpty(src)) {
            return false;
        }
        Matcher m = mobile_pattern.matcher(src);
        return m.matches();
    }
}
