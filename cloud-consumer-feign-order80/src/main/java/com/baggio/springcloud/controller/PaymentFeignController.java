package com.baggio.springcloud.controller;

import com.baggio.springcloud.entities.CommonResult;
import com.baggio.springcloud.entities.Payment;
import com.baggio.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2021/9/16
 * @Version 1.0
 */
@Slf4j
@RestController
public class PaymentFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @PostMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimout(@RequestBody Payment payment){
        // openfeign-bibbon 客户端一般默认等待1秒
        return paymentFeignService.paymentFeignTimout(payment);
    }

}
