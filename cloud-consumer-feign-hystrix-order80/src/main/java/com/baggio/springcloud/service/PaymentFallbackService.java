package com.baggio.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2021/9/18
 * @Version 1.0
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "----- PaymentFallbackService fall back-paymentInfo_OK, o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "----- PaymentFallbackService fall back-paymentInfo_TimeOut, o(╥﹏╥)o";
    }

}
