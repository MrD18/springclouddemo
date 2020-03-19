package com.yss.springcloud.controller;

import com.yss.springcloud.entity.CommonResult;
import com.yss.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: duhao
 * @date: 2020/3/16 20:55
 */
@RestController
@Slf4j
public class OrderConsulController {
    @Autowired
    private RestTemplate restTemplate;
    /**
     * 使用RestTemplate访问restful 接口时:
     * (url,requestMap,ResponseBean.class) 这三个参数分别代表
     * REST请求地址,请求参数,Http 响应转换被转换的对象类型
     */
//    private static final String REST_URL_PREFIX = "http://localhost:8001"; 只是固定了一个服务,多个服务不能实现动态调用

    private static final String REST_URL_PREFIX ="http://cloud-provider-payment"; // 这一块就是服务的名字, 实现微服务


    @GetMapping("/consumer/payment/consul")
    public String paymentInfo(){
        return   restTemplate.getForObject(REST_URL_PREFIX+"/payment/consul",String.class);

    }

    @GetMapping( "/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return  restTemplate.postForObject(REST_URL_PREFIX+"/payment/create",payment, CommonResult.class);
    }
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return  restTemplate.getForObject(REST_URL_PREFIX+"/payment/get/"+id,CommonResult.class);

    }
}
