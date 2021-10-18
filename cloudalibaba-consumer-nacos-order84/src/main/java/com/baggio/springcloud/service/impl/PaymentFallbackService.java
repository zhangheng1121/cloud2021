package com.baggio.springcloud.service.impl;

import com.baggio.springcloud.entities.CommonResult;
import com.baggio.springcloud.entities.Payment;
import com.baggio.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * @className: PyamentFallbackService
 * @description:
 * @author: liusCoding
 * @create: 2020-06-10 17:33
 */
@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444, "服务降级返回, --- PaymentFallbackService ", new Payment(id, "errorSerial"));
    }

}
