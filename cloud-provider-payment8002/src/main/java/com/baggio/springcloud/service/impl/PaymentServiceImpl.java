package com.baggio.springcloud.service.impl;

import com.baggio.springcloud.dao.PaymentDao;
import com.baggio.springcloud.entities.Payment;
import com.baggio.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Introduce:
 *  @Resource : java自带的注解
 *  @Autowired : spring自带的注解
 * @Author: zhangheng
 * @Date: 2021/9/10
 * @Version 1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

}
