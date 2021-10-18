package com.baggio.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2021/9/22
 * @Version 1.0
 */
@Configuration
public class GateWayConfig {

    /**
     * 配置了一个 id为path_rout_baggio 的路由规则
     * 当访问 http://localhost:9527/guonei 时会自动转发到地址 https://news.baidu.com/guonei
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        // https://news.baidu.com/guonei
        routes.route("path_rout_baggio",
                r -> r.path("/guonei").uri("https://news.baidu.com/guonei")).build();

        routes.route("path_rout_baggio2",
                r -> r.path("/guoji").uri("https://news.baidu.com/guoji")).build();

        return routes.build();
    }

}
