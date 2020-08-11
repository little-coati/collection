package com.my.platform.entity;

/**
 * @description: 人员信息实体类
 * @author: Zhou Lixiong
 * @date: 2020/8/4
 */
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthCountry() {
        return birthCountry;
    }

    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }

    public String getBirthProvince() {
        return birthProvince;
    }

    public void setBirthProvince(String birthProvince) {
        this.birthProvince = birthProvince;
    }

    public String getBirthCity() {
        return birthCity;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }

    public String getBirthAddress() {
        return birthAddress;
    }

    public void setBirthAddress(String birthAddress) {
        this.birthAddress = birthAddress;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getShortDescribe() {
        return shortDescribe;
    }

    public void setShortDescribe(String shortDescribe) {
        this.shortDescribe = shortDescribe;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getCreatedById() {
        return createdById;
    }

    public void setCreatedById(String createdById) {
        this.createdById = createdById;
    }

    public String getCreatedByName() {
        return createdByName;
    }

    public void setCreatedByName(String createdByName) {
        this.createdByName = createdByName;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdateById() {
        return updateById;
    }

    public void setUpdateById(String updateById) {
        this.updateById = updateById;
    }

    public String getUpdateByName() {
        return updateByName;
    }

    public void setUpdateByName(String updateByName) {
        this.updateByName = updateByName;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    public String getDeletedFlag() {
        return deletedFlag;
    }

    public void setDeletedFlag(String deletedFlag) {
        this.deletedFlag = deletedFlag;
    }

    public String getDeletedById() {
        return deletedById;
    }

    public void setDeletedById(String deletedById) {
        this.deletedById = deletedById;
    }

    public String getDeletedByName() {
        return deletedByName;
    }

    public void setDeletedByName(String deletedByName) {
        this.deletedByName = deletedByName;
    }

    public String getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }
}
