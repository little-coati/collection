package com.my.platform.mapper;

import com.my.platform.entity.PeopleInfo;
import com.my.platform.vo.reqVo.PeopleInfoReqVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: 周立雄
 * @description:
 * @date: 2020/8/5
 */
@Repository
public interface PeopleInfoMapper {

    List<PeopleInfo> queryPeopleInfoForMeByCond(PeopleInfoReqVo reqVo);

    List<PeopleInfo> queryPeopleInfoByCond(PeopleInfoReqVo reqVo);
}
