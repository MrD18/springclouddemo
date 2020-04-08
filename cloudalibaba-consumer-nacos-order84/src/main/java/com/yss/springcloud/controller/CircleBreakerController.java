package com.yss.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yss.springcloud.entity.CommonResult;
import com.yss.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**关于方法降级的一些配置:
 * 没有任何配置: 给客户error页面,不友好
 * 只配置fallback:只负责业务异常
 * 只配blockHandler:只负责sentinel控制台配置违规
 * 2个都配:如果不超过Sentinel的配置范围,正常访问,超过就会进入blockHandler
 *        如果不超过Sentinel的配置范围,是异常的访问,就会fallback 业务异常, 超过就会进入blockHandler,由Sentinel负责
 *exceptionsToIgnore:忽略某些异常,出现该异常的话直接抛出页面,不进行降级作用
 *
 * @author: duhao
 * @date: 2020/4/8 15:30
 */
@RestController
@Slf4j
public class CircleBreakerController {

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @Resource
    private RestTemplate restTemplate;
   @RequestMapping("/consumer/fallback/{id}")
   //@SentinelResource(value = "fallback") //没有配置
   //@SentinelResource(value = "fallback",fallback = "handlerFallback") //fallback只负责业务异常
  // @SentinelResource(value = "fallback",blockHandler = "blockHandler") //blockHandler只负责sentinel控制台配置违规
   //@SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler") // 这是2个都配的效果,各管个的
   @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler",
           exceptionsToIgnore = {IllegalArgumentException.class})  //如果出现这个异常,不在有fallback方法兜底,没有降级效果了
    public CommonResult<Payment> fallback(@PathVariable Long id) {
        CommonResult result = restTemplate.getForObject(serverURL + "/paymentSQL/" + id, CommonResult.class, id);
        if(id==4){
            throw new IllegalArgumentException("IllegalArgumentException,这是一个非法参数异常....");
        }else if (result.getData()==null){
            throw new NullPointerException("NullPointerException,该ID没有对应记录,空指针异常");
        }
  return  result;
    }

    //fallback
    public CommonResult handlerFallback(@PathVariable  Long id,Throwable e) {
        Payment payment = new Payment(id,"null");
        return new CommonResult<>(444,"兜底异常handlerFallback,exception内容  "+e.getMessage(),payment);
    }

    //blockHandler
    public CommonResult blockHandler(@PathVariable  Long id, BlockException blockException) {
        Payment payment = new Payment(id,"null");
        return new CommonResult<>(445,"blockHandler-sentinel限流,无此流水: blockException  "+blockException.getMessage(),payment);
    }



}
