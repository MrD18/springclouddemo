package com.yss.springcloud.service;

import com.yss.springcloud.entity.CommonResult;
import com.yss.springcloud.entity.Payment;
import org.springframework.stereotype.Component;

/**
 * @author: duhao
 * @date: 2020/4/8 17:00
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));

    }
}
