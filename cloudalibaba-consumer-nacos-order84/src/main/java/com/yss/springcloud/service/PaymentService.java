package com.yss.springcloud.service;

import com.yss.springcloud.entity.CommonResult;
import com.yss.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**提供者的名称调用,并且将回滚的方法 填在里面,实现解耦合
 * @author: duhao
 * @date: 2020/4/8 16:57
 */
@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping(value = "/paymentSQL/{id}")
    CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
