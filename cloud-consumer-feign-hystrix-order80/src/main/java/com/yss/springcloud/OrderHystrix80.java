package com.yss.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: duhao
 * @date: 2020/3/17 16:35
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderHystrix80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrix80.class,args);
    }
}
