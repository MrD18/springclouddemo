package com.yss.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: duhao
 * @date: 2020/4/7 11:31
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Sentinel8401 {
    public static void main(String[] args) {
        SpringApplication.run(Sentinel8401.class,args);

    }
}
