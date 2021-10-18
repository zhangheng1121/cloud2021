package com.baggio.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2021/9/10
 * @Version 1.0
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    //@LoadBalanced   // 使用 @LoadBalanced 注解赋予 RestTemplate 负载均衡的能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
