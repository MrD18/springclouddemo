package com.yss.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: duhao
 * @date: 2020/3/25 16:38
 */
@SpringBootApplication
@EnableDiscoveryClient // 直接用这个注解,不用特意的在关注Eurka
public class PaymentMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain9001.class,args);
    }
}
