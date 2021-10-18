package com.baggio.springcloud.controller;

import com.baggio.springcloud.domain.CommonResult;
import com.baggio.springcloud.domain.Order;
import com.baggio.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Project_Name: nlx2020
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2020/11/27 14:40
 * @Version 1.0
 */
@Slf4j
@RestController
public class OrderController {

    @Resource
    public OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }

    /*@GetMapping("/order/getIDBySnowFlake")
    public String getIDBySnowFlake(){
        return orderService.getIDBySnowFlake();
    }*/

}
