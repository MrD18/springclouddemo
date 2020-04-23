package com.yss.springcloud.controller;

import com.yss.springcloud.domain.CommonResult;
import com.yss.springcloud.domain.Order;
import com.yss.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: duhao
 * @date: 2020/4/15 17:54
 */
@RestController
@Slf4j
public class OrderController {
    @Resource
    private OrderService orderService;


    @GetMapping("/order/create")
    public CommonResult create(Order order){
orderService.create(order);
return new CommonResult(200,"订单创建成功");
    }

}
