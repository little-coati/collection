package com.my.platform.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @description: 性别枚举值翻译
 * @author: Karl
 * @date: 2020/8/5
 */
public class TransChineseUtil {
    public static String transSex(String sex) {
        if (StringUtils.equals("0",sex)) {
            return "男";
        } else if (StringUtils.equals("1",sex)) {
            return "女";
        } else if (StringUtils.equals("2",sex)) {
            return "跨性别者";
        } else {
            return sex;
        }
    }
}
