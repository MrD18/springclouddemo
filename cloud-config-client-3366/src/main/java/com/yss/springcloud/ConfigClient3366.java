package com.yss.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: duhao
 * @date: 2020/3/23 16:34
 */
@EnableEurekaClient
@SpringBootApplication
public class ConfigClient3366 {
    public static void main(String[] args) {
        SpringApplication.run( ConfigClient3366.class,args);
    }

}
