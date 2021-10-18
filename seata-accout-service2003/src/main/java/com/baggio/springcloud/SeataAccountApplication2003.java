package com.baggio.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @className: SeataAccoutApplication2003
 * @description:
 * @author: liusCoding
 * @create: 2020-06-12 09:35
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients
@EnableDiscoveryClient
public class SeataAccountApplication2003 {

    public static void main(String[] args) {
        SpringApplication.run(SeataAccountApplication2003.class, args);
    }

}
