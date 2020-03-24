package com.yss.springcloud.controller;

import com.yss.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: duhao
 * @date: 2020/3/24 10:59
 */
@RestController
public class SendMessageController {
    @Resource
    private IMessageProvider messageProvider;
    @GetMapping("/sendMessage")
    public String send(){
        return messageProvider.send();
    }

}
