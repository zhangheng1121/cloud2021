package com.baggio.springcloud.controller;

import com.baggio.springcloud.entities.CommonResult;
import com.baggio.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.baggio.springcloud.service.PaymentService;

import javax.annotation.Resource;

/**
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2021/9/10
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("****插入结果：" + result);

        if(result > 0){
            return new CommonResult(200, "插入数据库成功，serverPort：" + serverPort);
        }
        return new CommonResult(444, "插入数据库失败");
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);

        if(payment != null){
            return new CommonResult(200, "查询成功，serverPort：" + serverPort, payment);
        }
        return new CommonResult(444, "没有记录，查询的ID：" + id);
    }

    @GetMapping("/lb")
    public String getPaymentLB(){
        return serverPort;
    }

}
