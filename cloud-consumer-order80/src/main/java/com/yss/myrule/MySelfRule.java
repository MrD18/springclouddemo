package com.yss.myrule;

import com.netflix.loadbalancer.IRule;

import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**自定义 算法
 * 注意这个包 不能放在主启动类下的那个包中,需单独创建
 * @author: duhao
 * @date: 2020/3/17 9:12
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule(){
        // 定义为随机
        return new RandomRule();
    }
}
