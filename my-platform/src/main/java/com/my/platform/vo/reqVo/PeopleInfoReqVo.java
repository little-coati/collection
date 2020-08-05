package com.my.platform.vo.reqVo;

import lombok.Data;

/**
 * @author: 周立雄
 * @version: v1.0
 * @description: 人员信息查询传参
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
     *      3：跨性别者
     */
    private String sex;
    /**
     * 请求方式
     *      0：我
     *      1：其他人
     */
    private String queryType;
}