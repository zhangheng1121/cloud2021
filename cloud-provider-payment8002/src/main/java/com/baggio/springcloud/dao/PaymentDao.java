package com.baggio.springcloud.dao;

import com.baggio.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2021/9/9
 * @Version 1.0
 */
@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
