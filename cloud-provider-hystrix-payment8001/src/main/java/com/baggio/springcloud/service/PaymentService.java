package com.baggio.springcloud.service;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RuntimeUtil;
import cn.hutool.crypto.SecureUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2021/9/17
 * @Version 1.0
 */
@Service
public class PaymentService {


    // ---------------- 服务降级 -----------------
    /**
     * 正常访问，肯定OK
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id){
        return "线程池：" + Thread.currentThread().getName() + "\t" + " paymentInfo_OK: " + id + "\t" + "O(∩_∩)O哈哈~";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            // 自己设置峰值上线 3 秒（3秒以内走正常方法，3秒以上走 paymentInfo_TimeOutHandler 方法）
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="4000")
    })
    public String paymentInfo_TimeOut(Integer id){
        System.out.println("********************************");
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--------------------------------");
        return "线程池：" + Thread.currentThread().getName() + "\t" + " paymentInfo_TimeOut: " + id + "\t O(∩_∩)O哈哈~" + " 耗时(秒)";
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池：" + Thread.currentThread().getName() + "\t" + " 8001系统繁忙或者运行出错，请稍后再试！ \t" + "o(╥﹏╥)o";
    }


    // ---------------- 服务熔断 -----------------
    // 10秒钟的时间内，如果请求10次，失败率超过60%，进行熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),   // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),  // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),   // 时间窗口期 多少秒内
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),   // 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id < 0){
            throw new RuntimeException("****** id 不能为负数");
        }
        String setialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + setialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能为负数，请稍后再试， o(╥﹏╥)o  id：" + id;
    }

}
