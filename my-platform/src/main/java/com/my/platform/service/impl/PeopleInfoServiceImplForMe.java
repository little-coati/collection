package com.my.platform.service.impl;

import com.my.platform.entity.PeopleInfo;
import com.my.platform.mapper.PeopleInfoMapper;
import com.my.platform.service.PeopleInfoService;
import com.my.platform.util.TransChineseUtil;
import com.my.platform.vo.reqvo.PeopleInfoReqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Karl
 * @date: 2020/8/5
 */
@Service("me")
public class PeopleInfoServiceImplForMe implements PeopleInfoService {

    @Autowired
    private PeopleInfoMapper peopleInfoMapper;

    /**
     * 根据条件查询人员身份信息（本人）
     *
     * @param reqVo 查询传参
     * @return 查询结果
     */
    @Override
    public List<PeopleInfo> queryPeopleInfoByCond(PeopleInfoReqVo reqVo) {
        List<PeopleInfo> list = peopleInfoMapper.queryPeopleInfoForMeByCond(reqVo);
        if (list != null && !list.isEmpty()) {
            transChinese(list);
        }
        return list;
    }

    /**
     * 翻译性别信息的方法
     *
     * @param list 人员信息的list集合
     * @return 翻译后的list
     */
    private List<PeopleInfo> transChinese(List<PeopleInfo> list) {
        for (PeopleInfo peopleInfo : list) {
            peopleInfo.setSex(TransChineseUtil.transSex(peopleInfo.getSex()));
        }
        return list;
    }
}