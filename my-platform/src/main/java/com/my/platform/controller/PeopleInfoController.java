package com.my.platform.controller;

import com.my.common.entity.PeopleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: 人员信息相关
 * @author: Zhou Lixiong
 * @date: 2020/8/4
 */
@RestController
@RequestMapping("pi")
public class PeopleInfoController {

//    @Autowired
//    @Resource
//    private

    public PeopleInfo getPeopleInfoByCond(PeopleInfoReqVo reqVo) {
        return
    }
}
