package com.baggio.springcloud.controller;

import com.baggio.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2021/9/17
 * @Version 1.0
 */
@Slf4j
@RestController
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfo_OK(id);
        return result;
    }

    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
    /*@HystrixCommand(fallbackMethod = "paymentInfo_TimeOutMethod", commandProperties = {
            // 自己设置峰值上线 3 秒（3秒以内走正常方法，3秒以上走 paymentInfo_TimeOutHandler 方法）
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="6000")
    })*/
    @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        int age = 10/0;
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        return result;
    }

    public String paymentInfo_TimeOutMethod(@PathVariable("id") Integer id){
        return "消费者80，对方支付系统系统繁忙请10秒后再试，或者自己运行出错，请检查自己，o(╥﹏╥)o";
    }

    // 下面是全局 fallback 方法
    public String payment_Global_FallbackMethod(){
        return "Global 异常处理信息，请稍后后再试，o(╥﹏╥)o";
    }

}
