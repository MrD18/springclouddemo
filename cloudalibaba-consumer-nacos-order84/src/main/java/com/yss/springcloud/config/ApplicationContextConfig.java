package com.yss.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**服务调用采用RestTemplate
 * @author: duhao
 * @date: 2020/4/8 15:26
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
   @LoadBalanced
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }

}
