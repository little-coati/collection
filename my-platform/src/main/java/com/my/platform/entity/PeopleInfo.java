package com.my.platform.entity;

import lombok.Data;

/**
 * @description: 人员信息实体类
 * @author: Zhou Lixiong
 * @date: 2020/8/4
 */
@Data
public class PeopleInfo {
    /**
     * 主键
     */
    private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     *      0：男
     *      1：女
     *      3：跨性别者
     */
    private String sex;
    /**
     * 出生日期
     */
    private String birthday;
    /**
     * 出生国家
     */
    private String birthCountry;
    /**
     * 出生省份
     */
    private String birthProvince;
    /**
     * 出生城市
     */
    private String birthCity;
    /**
     * 出生详细地址
     */
    private String birthAddress;
    /**
     * 与我的关系
     */
    private String relation;
    /**
     * 描述
     */
    private String describe;
    /**
     * 简单描述
     */
    private String shortDescribe;
    /**
     * 毕业院校
     */
    private String university;
    /**
     * 学位
     *      0：专科
     *      1：本科
     *      2：研究生
     *      3：博士
     *      4：其他
     */
    private String educationLevel;
    /**
     * 创建者id
     */
    private String createdById;
    /**
     * 创建者姓名
     */
    private String createdByName;
    /**
     * 创建时间
     */
    private String createdAt;
    /**
     * 最后更新者id
     */
    private String updateById;
    /**
     * 最后更新者姓名
     */
    private String updateByName;
    /**
     * 最后更新时间
     */
    private String updateAt;
    /**
     * 删除标志 Y/N
     */
    private String deletedFlag;
    /**
     * 删除者id
     */
    private String deletedById;
    /**
     * 删除者姓名
     */
    private String deletedByName;
    /**
     * 删除时间
     */
    private String deletedAt;
}
