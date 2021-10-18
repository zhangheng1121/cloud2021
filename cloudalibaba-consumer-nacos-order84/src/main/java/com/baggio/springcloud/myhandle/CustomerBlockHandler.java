package com.baggio.springcloud.myhandle;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.baggio.springcloud.entities.CommonResult;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Project_Name: nlx2020
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2020/11/25 16:00
 * @Version 1.0
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(@PathVariable("id") Long id, BlockException exception){
        return new CommonResult(444, "按客户自定义, global handlerException -- 1");
    }

    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(444, "按客户自定义, global handlerException -- 2");
    }

}
