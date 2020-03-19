package com.yss.springcloud.controller;

import com.yss.springcloud.entity.CommonResult;
import com.yss.springcloud.entity.Payment;
import com.yss.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: duhao
 * @date: 2020/3/17 11:20
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
       return   paymentFeignService.getPaymentById(id);

    }

}
