package com.baggio.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2021/9/28
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelMain8401 {

    public static void main(String[] args) {
        SpringApplication.run(SentinelMain8401.class, args);
    }

}
