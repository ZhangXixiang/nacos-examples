package com.alibaba.nacos.example.spring.boot.listener;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.example.spring.boot.YourStaticClass;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @description: [description]
 * @author: zxx
 * @createDate: 2024/1/16 21:56
 * @version: [v1.0]
 */
@Component
public class ConfigListener implements ApplicationListener<ApplicationReadyEvent> {

    // 通过 @Value 注解获取配置中心的参数
    // @Value("${your.config.parameter}")
    // private String configParameter;


    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private String useLocalCache;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        // 在应用程序启动后执行

        // 将参数传递给静态类的方法或属性
        YourStaticClass.setSomeProperty(useLocalCache);
    }
}