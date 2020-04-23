package com.yss.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: duhao
 * @date: 2020/4/22 17:04
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients// 开启Feigin  别的服务也可以调用
@EnableDiscoveryClient // 注册中心发现
public class SeataOrderMainApp2002 {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrderMainApp2002.class,args);
    }
}
