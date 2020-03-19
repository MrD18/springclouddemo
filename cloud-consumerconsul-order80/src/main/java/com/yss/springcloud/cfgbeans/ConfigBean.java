package com.yss.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: duhao
 * @date: 2020/3/12 18:24
 */
@Configuration
public class ConfigBean {
    @Bean
    @LoadBalanced  //实现调用服务端的负载均衡
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }
}
