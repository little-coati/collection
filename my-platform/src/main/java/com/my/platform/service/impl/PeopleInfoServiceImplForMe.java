package com.my.platform.service.impl;

import com.my.platform.entity.PeopleInfo;
import com.my.platform.mapper.PeopleInfoMapper;
import com.my.platform.service.PeopleInfoService;
import com.my.platform.vo.reqVo.PeopleInfoReqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: 周立雄
 * @version: v1.0
 * @description:
 * @date: 2020/8/5
 */
@Service("me")
public class PeopleInfoServiceImplForMe implements PeopleInfoService {

    @Autowired
    private PeopleInfoMapper peopleInfoMapper;

    @Override
    public PeopleInfo queryPeopleInfoByCond(PeopleInfoReqVo reqVo) {
        return null;
    }
}