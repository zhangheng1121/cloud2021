package com.baggio.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.baggio.springcloud.entities.CommonResult;
import com.baggio.springcloud.entities.Payment;
import com.baggio.springcloud.myhandle.CustomerBlockHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2021/9/29
 * @Version 1.0
 */
@Slf4j
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource(){
        return new CommonResult(200, "按资源名称限流测试OK", new Payment(2020L, "serial001"));
    }
    public CommonResult handleException(BlockException exception){
        return new CommonResult(444, exception.getClass().getCanonicalName() + " \t " + "服务不可用");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl(){
        return new CommonResult(200, "按url限流测试OK", new Payment(2020L, "serial002"));
    }

    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler", blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerException2")
    public CommonResult customerBlockHandler(){
        return new CommonResult(200, "按客户自定义", new Payment(2020L, "serial003"));
    }

}
