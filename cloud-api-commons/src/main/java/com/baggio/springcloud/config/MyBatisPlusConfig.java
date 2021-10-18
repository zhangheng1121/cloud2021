package com.baggio.springcloud.config;

import com.sun.xml.internal.bind.v2.TODO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2021/10/11
 * @Version 1.0
 */
public class MyBatisPlusConfig {

    // FIXME: 2021/10/11
    // TODO: 2021/10/11
    public static void main(String[] args) {

    }

    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

}
