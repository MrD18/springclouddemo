package com.yss.springcloud.controller;

import com.yss.springcloud.entity.CommonResult;
import com.yss.springcloud.entity.Payment;
import com.yss.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**使用最原始的restTemplate 远程调用服务提供者
 * @author: duhao
 * @date: 2020/3/12 18:24
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancer loadBalancer;  // 手写的负载均衡算法

    @Autowired
    private DiscoveryClient discoveryClient;   // 获取服务的列表
    /**
     * 使用RestTemplate访问restful 接口时:
     * (url,requestMap,ResponseBean.class) 这三个参数分别代表
     * REST请求地址,请求参数,Http 响应转换被转换的对象类型
     */
//    private static final String REST_URL_PREFIX = "http://localhost:8001"; 只是固定了一个服务,多个服务不能实现动态调用

    private static final String REST_URL_PREFIX ="http://CLOUD-PAYMENT-SERVICE"; // 这一块就是服务的名字, 实现微服务
   @GetMapping( "/consumer/payment/create")
    public  CommonResult<Payment> create(Payment payment){
       return  restTemplate.postForObject(REST_URL_PREFIX+"/payment/create",payment, CommonResult.class);
    }
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
       return  restTemplate.getForObject(REST_URL_PREFIX+"/payment/get/"+id,CommonResult.class);
    }
    @GetMapping("/consumer/payment/getentity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(REST_URL_PREFIX + "/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else {
            return new CommonResult(400,"操作失败");
        }
    }
@GetMapping(value = "/consumer/payment/lb")
public  String getPaymentLB(){
    List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
    if (instances==null||instances.size()<=0){
        return  null;
    }
    ServiceInstance serviceInstance = loadBalancer.instances(instances);
    URI uri = serviceInstance.getUri();
    return restTemplate.getForObject(uri+"/payment/lb",String.class);
}

    // ====================> zipkin+sleuth  链路监控测试  80调用8001
    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin()
    {
        String result = restTemplate.getForObject("http://localhost:8001"+"/payment/zipkin/", String.class);
        return result;
    }


}
