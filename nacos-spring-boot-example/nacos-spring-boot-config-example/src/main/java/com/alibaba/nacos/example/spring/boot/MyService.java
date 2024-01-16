package com.alibaba.nacos.example.spring.boot;

/**
 * @description: [description]
 * @author: zxx
 * @createDate: 2024/1/16 22:22
 * @version: [v1.0]
 */
import org.springframework.stereotype.Service;

@Service
public class MyService {

    public void processConfigChange(String updatedConfig) {
        // 在这里处理配置变更的逻辑

        System.out.println("Received updated config in MyService: " + updatedConfig);
        YourStaticClass.setSomeProperty(updatedConfig);
        System.out.println("someProperty==="+updatedConfig);
    }
}
