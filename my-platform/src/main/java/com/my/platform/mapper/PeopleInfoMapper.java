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

    /**
     * 根据条件查询人员身份信息（本人）
     *
     * @param reqVo 查询传参
     * @return 查询结果
     */
    List<PeopleInfo> queryPeopleInfoForMeByCond(PeopleInfoReqVo reqVo);

    /**
     * 根据条件查询人员身份信息（非本人）
     *
     * @param reqVo 查询传参
     * @return 查询结果
     */
    List<PeopleInfo> queryPeopleInfoByCond(PeopleInfoReqVo reqVo);
}
