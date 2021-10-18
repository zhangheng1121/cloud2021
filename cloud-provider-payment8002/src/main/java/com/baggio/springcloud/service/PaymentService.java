package com.baggio.springcloud.service;

import com.baggio.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2021/9/10
 * @Version 1.0
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
