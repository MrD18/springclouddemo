package com.yss.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: duhao
 * @date: 2020/4/15 17:57
 */
@Configuration
@MapperScan({"com.yss.springcloud.dao"})
public class MyBatisConfig {

}