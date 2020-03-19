package com.yss.springcloud.service;

import org.springframework.stereotype.Component;

/**这个类实现了 PaymentHystrixService 重写里面的方法, 对里面所有的方法进行处理, 然后加载fegin 那个注解里面,
 * 相当于配置了切面
 * @author: duhao
 * @date: 2020/3/17 17:53
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "--PaymentFallbackService fall back - paymentInfo_OK,o(╥﹏╥)o ";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "--PaymentFallbackService fall back - paymentInfo_TimeOut,o(╥﹏╥)o ";
    }
}
