package com.baggio.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2021/9/10
 * @Version 1.0
 */
@EnableEurekaServer // eureka 服务注册中心
@SpringBootApplication
public class EurekaMain7001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class, args);
    }

}
