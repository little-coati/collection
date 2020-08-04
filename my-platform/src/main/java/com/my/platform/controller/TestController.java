package com.my.platform.controller;

import com.my.platform.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Zhou Lixiong
 * @date: 2020/8/3
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("getWords")
    public String getYourWord() {
        return testService.getYourWord();
    }
}
