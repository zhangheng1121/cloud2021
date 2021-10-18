package com.baggio.springcloud.service.impl;

import com.baggio.springcloud.dao.OrderDao;
import com.baggio.springcloud.domain.Order;
import com.baggio.springcloud.service.AccountService;
import com.baggio.springcloud.service.OrderService;
import com.baggio.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Project_Name: nlx2020
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2020/11/27 14:22
 * @Version 1.0
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    public OrderDao orderDao;
    @Resource
    public StorageService storageService;
    @Resource
    public AccountService accountService;

    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     * 简单说：下订单->扣库存->减余额->改状态
     */
    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void create(Order order) {

        //1 新建订单
        log.info("-----> 开始新建订单");
        orderDao.create(order);

        //2 扣减库存
        log.info("----->订单微服务开始调用库存，做扣减Count");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("----->订单微服务开始调用库存，做扣减end");

        //3 扣减账户
        log.info("----->订单微服务开始调用账户，做扣减Money");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("----->订单微服务开始调用账户，做扣减end");

        //4 修改订单状态，从零到1,1代表已经完成
        log.info("----->修改订单状态开始");
        orderDao.update(order.getUserId(), 0);
        log.info("----->修改订单状态结束");
        //int x = 10/0;
        log.info("----->下订单结束了，O(∩_∩)O哈哈~");

    }


    /*@Resource
    public IdGeneratorSnowflake idGeneratorSnowflake;

    public String getIDBySnowFlake(){
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for(int i=0; i<=20; i++){
            executorService.submit(() -> {
                System.out.println(idGeneratorSnowflake.snowflakeId());
            });
        }
        executorService.shutdown();

        return "hello snowflake";
    }*/




}


