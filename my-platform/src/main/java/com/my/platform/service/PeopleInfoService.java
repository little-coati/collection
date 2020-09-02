package com.my.platform.service;

import com.my.platform.entity.PeopleInfo;
import com.my.platform.vo.reqvo.PeopleInfoReqVo;

import java.util.List;

/**
 * @description:
 * @author: Karl
 * @date: 2020/8/5
 */
public interface PeopleInfoService {
    /**
     * 根据条件查询人员身份信息
     *
     * @param reqVo 查询传参
     * @return 查询结果
     */
    List<PeopleInfo> queryPeopleInfoByCond(PeopleInfoReqVo reqVo);
}
