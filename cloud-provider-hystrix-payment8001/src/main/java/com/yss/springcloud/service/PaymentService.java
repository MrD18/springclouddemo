package com.yss.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author: duhao
 * @date: 2020/3/17 16:23
 */
@Service
public class PaymentService {
    /**
     * 正常访问
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + " paymentInfo_OK,id:" + id + "\t" + "O(∩_∩)O哈哈~";
    }
    /**
     * 超时访问
     * @param id
     * @return
     */
    // 对于这个方法 我们加熔断 设定时间为3s 超过3s 就熔断
    @HystrixCommand(fallbackMethod = "payment_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value ="5000")})
    public String paymentInfo_TimeOut(Integer id) {
        try {
            // 暂停毫秒
            TimeUnit.MILLISECONDS.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
        return "线程池:" + Thread.currentThread().getName() + id + "\t" + "O(∩_∩)O哈哈~  耗时(秒)" ;
    }

    // 要写一个兜底的方法
    public  String payment_TimeOutHandler(Integer id){
        return "线程池: " + Thread.currentThread().getName()+"  payment_TimeOutHandler,id: "+id+"\t" + "o(╥﹏╥)o";
    }


    // 服务熔断---------------------------------------------    具体的值 都在这个抽象类中: HystrixCommandProperties  shift+shift
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  // 是否开启熔断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), // 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id<0){
            throw  new RuntimeException("****id 不能是负数*****");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功,流水号: "+serialNumber;
    }

    public  String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能为负数,请稍后再试,o(╥﹏╥)o   id: "+id;
    }

}



