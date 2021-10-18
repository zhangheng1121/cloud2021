package com.baggio.springcloud.service;

import com.baggio.springcloud.domain.Order;

/**
 * @Project_Name: nlx2020
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2020/11/27 14:22
 * @Version 1.0
 */
public interface OrderService {

    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     * 简单说：下订单->扣库存->减余额->改状态
     */
    void create(Order order);

    //String getIDBySnowFlake();

}
