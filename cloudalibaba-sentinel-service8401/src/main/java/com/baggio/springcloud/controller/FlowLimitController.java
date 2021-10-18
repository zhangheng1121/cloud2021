package com.baggio.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2021/9/28
 * @Version 1.0
 */
@Slf4j
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String tesrA(){
        /*try {
            // 暂停 0.8 秒
            TimeUnit.MILLISECONDS.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return "------testA";
    }

    @GetMapping("/testB")
    public String tesrB(){
        log.info(Thread.currentThread().getName() + " \t ....testB");
        return "------testB";
    }

    @GetMapping("/testD")
    public String tesrD(){
        /*try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testD 测试RT");*/
        log.info("testD 异常比例");
        int i = 10/0;
        return "------testD";
    }

    @GetMapping("/testE")
    public String tesrE(){
        log.info("testE 测试异常数");
        int i = 10/0;
        return "------testE";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2){
        int age = 10/0;
        return "------testHotKey";
    }
    public String deal_testHotKey(String p1, String p2, BlockException exception){
        return "------deal_testHotKey, o(╥﹏╥)o";
    }

}
