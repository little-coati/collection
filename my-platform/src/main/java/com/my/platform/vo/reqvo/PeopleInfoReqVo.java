package com.my.platform.vo.reqvo;

import com.my.platform.validate.annotation.IsTel;
import com.my.platform.validate.annotation.Sex;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @description: 人员信息查询传参
 * @author: Karl
 * @date: 2020/8/5
 */
@Data
public class PeopleInfoReqVo {
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     *      0：男
     *      1：女
     *      2：跨性别者
     */
    @Sex
    private String sex;
    /**
     * 请求方式
     *      0：我
     *      1：其他人
     */
    @NotEmpty(message = "查询类型不能为空")
    private String queryType;
    /**
     * 手机号码
     */
    @IsTel
    private String tel;
}