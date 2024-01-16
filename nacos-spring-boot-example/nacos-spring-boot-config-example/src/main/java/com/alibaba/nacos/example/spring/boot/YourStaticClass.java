package com.alibaba.nacos.example.spring.boot;

/**
 * @description: [description]
 * @author: zxx
 * @createDate: 2024/1/16 21:58
 * @version: [v1.0]
 */
public class YourStaticClass {

    private static String someProperty;

    public static String getSomeProperty() {
        return someProperty;
    }

    public static void setSomeProperty(String value) {
        someProperty = value;
    }
}