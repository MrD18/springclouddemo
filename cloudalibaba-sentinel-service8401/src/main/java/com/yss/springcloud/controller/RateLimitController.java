package com.yss.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yss.springcloud.entity.CommonResult;
import com.yss.springcloud.entity.Payment;
import com.yss.springcloud.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: duhao
 * @date: 2020/4/8 10:27
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handleException1")
    public CommonResult byResource()
        {
        return new CommonResult(200,"按资源名称限流测试OK",new Payment(2020L,"serial001"));
    }
         //把这块信息独立出来,解耦合处理
//    public CommonResult handleException(BlockException exception) {
//       return new CommonResult(444, exception.getClass().getCanonicalName() + "\t 服务不可用");
//
//    }
    }
