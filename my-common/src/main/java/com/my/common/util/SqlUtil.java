package com.my.common.util;


import org.apache.commons.lang3.StringUtils;

/**
 * @description: 模糊查询字符串特殊字符处理
 * @author: Karl
 * @date: 2020/3/9
 */
public class SqlUtil {

    /**
     * sql模糊查询特殊词替换（"_"和"%"）
     *
     * @param specialWord 模糊查询传参
     * @return 处理之后的字符串
     */
    public static String specialWordReplace(String specialWord) {

        //空字符串直接返回
        if (StringUtils.isBlank(specialWord)) {
            return specialWord;
        }
         String[] fbsArr = { "\\","$","(", ")","*","+",".","[", "]","?","^","{","}","|","%","_" };
         for (String key : fbsArr) {
             if (specialWord.contains(key)) {
                 specialWord = specialWord.replace(key, "\\" + key);
             }
         }
        return specialWord;
    }
}
