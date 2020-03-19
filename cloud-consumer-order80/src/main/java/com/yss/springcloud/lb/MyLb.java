package com.yss.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.lang.reflect.AnnotatedType;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**手写负载均衡算法
 * @author: duhao
 * @date: 2020/3/17 10:11
 */
@Component
public class MyLb implements LoadBalancer {


   private AtomicInteger atomicInteger=new AtomicInteger(0);

   public  final int getAndIncrement(){
       int current;
       int next;
       do {
           current=this.atomicInteger.get();
           next=current>2147483647?0:current+1;
       }while (!this.atomicInteger.compareAndSet(current,next));
       System.out.println("******第几次访问,次数next:"+next);
       return next;
   }
   // 负载均衡算法
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
           int index = getAndIncrement()%serviceInstances.size();

       return serviceInstances.get(index);
    }
}
