package com.my.platform.service;

import com.my.platform.entity.PeopleInfo;
import com.my.platform.vo.reqVo.PeopleInfoReqVo;

/**
 * @author: 周立雄
 * @description:
 * @date: 2020/8/5
 */
public interface PeopleInfoService {
    PeopleInfo queryPeopleInfoByCond(PeopleInfoReqVo reqVo);
}
