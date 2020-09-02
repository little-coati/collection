package com.my.common.util;

import java.util.UUID;

/**
 * @description: 生成32位的UUID
 * @author: Karl
 * @date: 2019/11/20
 */
public class UUIDUtil {

    /**
     * 生成32位UUID
     * @return
     */
    public static String getUUID32(){
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }

}
