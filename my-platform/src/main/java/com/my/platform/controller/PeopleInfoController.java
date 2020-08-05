package com.my.platform.controller;

import com.my.common.vo.Result;
import com.my.platform.entity.PeopleInfo;
import com.my.platform.service.PeopleInfoService;
import com.my.platform.util.TransChineseUtil;
import com.my.platform.vo.reqVo.PeopleInfoReqVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 人员信息相关
 * @author: Zhou Lixiong
 * @date: 2020/8/4
 */
@RestController
@RequestMapping("pi")
public class PeopleInfoController {

    @Autowired
    @Resource(name = "me")
    private PeopleInfoService peopleInfoServiceForMe;

    @Autowired
    @Resource(name = "other")
    private PeopleInfoService peopleInfoService;

    @PostMapping("getPI")
    public Result getPeopleInfoByCond(PeopleInfoReqVo reqVo) {
        List<PeopleInfo> list;
        if (StringUtils.equals(reqVo.getQueryType(),"0")) {
            list = peopleInfoServiceForMe.queryPeopleInfoByCond(reqVo);
        } else {
            list = peopleInfoServiceForMe.queryPeopleInfoByCond(reqVo);
        }
        if (list.isEmpty()) {
            return Result.ok("暂无数据！");
        } else {
            transChinese(list);
            return Result.ok(list);
        }
    }

    private List<PeopleInfo> transChinese(List<PeopleInfo> list) {
        for (PeopleInfo peopleInfo : list) {
            peopleInfo.setSex(TransChineseUtil.transSex(peopleInfo.getSex()));
        }
        return list;
    }
}
