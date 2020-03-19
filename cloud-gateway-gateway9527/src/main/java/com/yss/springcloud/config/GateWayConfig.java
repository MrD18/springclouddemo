package com.yss.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**自定义路由规则
 * @author: duhao
 * @date: 2020/3/18 20:30
 */
@Configuration
public class GateWayConfig {
   // http://news.baidu.com/guoji
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        //利用路由构建器获得 routes   类似yml文件中的 routes
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("com.yss",r->r.path("/guoji")
         .uri("http://news.baidu.com/guoji")).build(); // 访问 guoji  就会跳转到 http://new.baidu.com/guonei
        return  routes.build();
    }
}
