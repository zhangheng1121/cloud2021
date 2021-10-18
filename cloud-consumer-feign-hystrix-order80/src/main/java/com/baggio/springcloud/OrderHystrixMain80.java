package com.baggio.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2021/9/17
 * @Version 1.0
 */
@EnableHystrix
@EnableFeignClients
@SpringBootApplication
public class OrderHystrixMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain80.class, args);
    }

}
