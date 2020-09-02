package com.my.platform.controller;

import com.my.common.vo.Result;
import com.my.platform.entity.PeopleInfo;
import com.my.platform.service.PeopleInfoService;
import com.my.platform.vo.reqvo.PeopleInfoReqVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 人员信息相关
 * @author: Karl
 * @date: 2020/8/4
 */
@Slf4j
@RestController
@RequestMapping("pi")
public class PeopleInfoController {

    @Autowired
    @Resource(name = "me")
    private PeopleInfoService peopleInfoServiceForMe;

    @Autowired
    @Resource(name = "other")
    private PeopleInfoService peopleInfoService;

    /**
     * 根据条件查询人员身份信息
     *
     * @param reqVo 查询传参
     * @return 查询结果
     */
    @PostMapping("getPI")
    public Result getPeopleInfoByCond(@Validated @RequestBody PeopleInfoReqVo reqVo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return Result.error(bindingResult.getFieldError().getDefaultMessage());
        }
        log.info("查询人员身份信息，传参：{}",reqVo);
        List<PeopleInfo> list;
        String mine = "0";
        if (StringUtils.equals(reqVo.getQueryType(),mine)) {
            list = peopleInfoServiceForMe.queryPeopleInfoByCond(reqVo);
        } else {
            list = peopleInfoService.queryPeopleInfoByCond(reqVo);
        }
        if (list == null || list.isEmpty()) {
            return Result.ok("暂无数据！");
        } else {
            return Result.ok(list);
        }
    }
}
