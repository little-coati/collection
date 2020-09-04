package com.my.platform.controller;

import com.my.common.vo.Result;
import com.my.platform.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Karl
 * @date: 2020/8/3
 */
@Slf4j
@RequestMapping("test")
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    /**
     * 测试全局捕捉异常信息
     *
     * @return 报错堆栈信息
     */
    @GetMapping("testException")
    public Result testException() {
        log.info("测试全局捕捉异常信息");
        testService.testException();
        return Result.ok("ok");
    }
}
