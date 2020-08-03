package com.my.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @description:
 * @author: jiangjie
 * @date: 2019/11/21
 */
public class StringUtil {
    /**
     * 获取换行符，区分不同系统
     * /r Mac；/n Unix/Linux；/r/n Windows
     * @return
     */
    public static String getEnterMark(){
        return System.getProperty("line.separator");
    }
    /**
     * 清除首位空格
     * @return
     */
    public static String trim(String msg)
    {
        if(msg==null)
            return null;
        return msg.trim();
    }
    /**
     * 字符串内容格式化输出，内部使用{0}\{1}\{2}...为参数占位符</br>
     * 参数格式：ArgumentIndex[,FormatType[,FormatStyle]] </br>
     * FormatType 取值:number,date，time，choice </br>
     * FormatType 样式：如：#.## </br>
     * 注：'{' 可输出左花括号(单写左花括号会报错，而单写右花括号将正常输出)</br>
     * @param msg 格式化模板
     * @param args 不固定参数
     * @return
     */
    public static String format(String msg, Object... args)
    {
        return java.text.MessageFormat.format(msg, args);
    }

    /**
     * 转换字符串到
     * @param num
     * @return
     */
    public static Integer getInt(String num){
        if(num==null || num.trim().isEmpty())
            return 0;
        if(!num.matches("^(\\d|-)\\d{0,9}$"))
            return 0;
        try {
            return Integer.parseInt(num);
        } catch (Exception e) {
            return 0;
        }
    }
    public static String getString(Object obj){
        return obj == null ? null : obj.toString();
    }
    public static String getString(Integer num){
        return getString(num,"");
    }
    public static String getString(Integer num,String def){
        if(num == null)
            return def;
        return num.toString();
    }

    /**
     * 字符串是否为空
     * @param str
     * @return
     */
    public static boolean isNullOrEmpty(String str){
        return str==null || str.trim().isEmpty();
    }
    /**
     * 比较两个字符串是否相等，忽略大小写
     * @param str1
     * @param str2
     * @return
     */
    public static boolean equalsIgnoreCase(String str1 ,String str2){
    /*    String tmp = str1==null?"":str1;
        return tmp.equalsIgnoreCase(str2);*/
        //直接改写
        String tmp="";
        if (str1!=null){
            tmp =str1;
        }
        return tmp.equalsIgnoreCase(str2);
    }

    /**
     * 删除起始字符
     * @param str
     * @return
     */
    public static String trimStart(String str,String trim){
        if(str==null)
            return null;
        return str.replaceAll("^("+trim+")+", "");
    }
    /**
     * 删除末尾字符
     * @param str
     * @return
     */
    public static String trimEnd(String str,String trim){
        if(str==null)
            return null;
        return str.replaceAll("("+trim+")+$", "");
    }
    /**
     * 以字符开头
     * @param s
     * @return
     */
    public static boolean startWith(String str,String s){
        return str.startsWith(s);
    }
    /**
     * 以字符末尾
     * @param s
     * @return
     */
    public static boolean endWith(String str,String s){
        return str.endsWith(s);
    }

    /**
     * 这里以字符串数组为例
     * 采用mapreduce原理，生成一组以数组元素为key,相同元素的个数为value的中间键值对
     * 这里将mapreduce分开来写方便阅读，也可以写成一个函数
     * @param arrays
     */
    public static HashMap<String, Integer> mapReduce(ArrayList<String[]> arrays) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        // 不要看到两个for就以为时间复杂度为n^2，这里只是有多个数组参数而已
        for (String[] array : arrays) {
            for (String elem : array) {
                if (hashMap.containsKey(elem)) {
                    hashMap.put(elem, hashMap.get(elem) + 1);
                }
                else {
                    hashMap.put(elem, 1);
                }
            }
        }

        return reduce(hashMap, arrays.size());
    }

    /**
     * 统计出相同元素个数正好是数组(参数)个数的元素（也就是每个数组中都有的元素）
     * 移除value不等于数组参数个数的键值对，并组成新的map
     * @param hashMap
     * @param arrayCount
     * @return
     */
    public static HashMap<String, Integer> reduce(HashMap<String, Integer> hashMap, final Integer arrayCount) {
        Iterator<String> iter = hashMap.keySet().iterator();
        String key;

        while(iter.hasNext()) {
            key = iter.next();

            if (!hashMap.get(key).equals(arrayCount)) {
                // 不能使用 hashMap.remove(key);
                iter.remove();
            }
        }
        return hashMap;
    }
}
