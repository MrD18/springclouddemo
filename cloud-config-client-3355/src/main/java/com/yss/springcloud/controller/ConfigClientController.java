package com.yss.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: duhao
 * @date: 2020/3/23 11:23
 */
@RestController
@RefreshScope // 手动刷新 动态刷新
public class ConfigClientController {
    @Value("${config.info}")
    private  String configInfo;
    @GetMapping("/configinfo")
    public  String getConfigInfo(){
        return configInfo;
    }
}
