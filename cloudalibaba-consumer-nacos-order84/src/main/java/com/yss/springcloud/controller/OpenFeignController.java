package com.yss.springcloud.controller;

import com.yss.springcloud.entity.CommonResult;
import com.yss.springcloud.entity.Payment;
import com.yss.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/** 采用openfegin 调用
 * @author: duhao
 * @date: 2020/4/8 16:57
 */
@RestController
@Slf4j
public class OpenFeignController {
    @Autowired
    private PaymentService paymentService;
@GetMapping("/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable Long id){
         return paymentService.paymentSQL(id);
    }
}
