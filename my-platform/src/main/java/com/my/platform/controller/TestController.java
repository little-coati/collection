package com.my.platform.controller;

import com.my.common.util.StringUtil;
import com.my.common.vo.Result;
import com.my.platform.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Zhou Lixiong
 * @date: 2020/8/3
 */
@Slf4j
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private TestService testService;

    /**
     * 打印完整的报错堆栈信息
     *
     * @return 报错堆栈信息
     */
    @GetMapping("testException")
    public Result testException() {
        try {
            testService.testException();
        } catch (Exception e) {
            log.info("打印堆栈信息",e);
            return Result.ok(StringUtil.getStackTrace(e));
        }
        return Result.ok("ok");
    }
}
