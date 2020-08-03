package com.my.platform.service.impl;

import com.my.platform.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Zhou Lixiong
 * @date: 2020/8/3
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public String getYourWord() {
        return "我的电脑开机键很独特";
    }
}
