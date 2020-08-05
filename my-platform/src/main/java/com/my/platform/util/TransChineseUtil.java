package com.my.platform.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @description:
 * @author: Zhou Lixiong
 * @date: 2020/8/5
 */
public class TransChineseUtil {
    public static String transSex(String sex) {
        if (StringUtils.equals("0",sex)) {
            return "男";
        } else if (StringUtils.equals("1",sex)) {
            return "女";
        } else if (StringUtils.equals("3",sex)) {
            return "跨性别者";
        } else {
            return sex;
        }
    }
}
