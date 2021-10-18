package com.baggio.springcloud.controller;

import com.baggio.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2021/9/24
 * @Version 1.0
 */
@Slf4j
@RestController
public class SendMessageConntroller {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping(value = "/sendMessage")
    public String sendMessage(){
        return messageProvider.send();
    }

}
