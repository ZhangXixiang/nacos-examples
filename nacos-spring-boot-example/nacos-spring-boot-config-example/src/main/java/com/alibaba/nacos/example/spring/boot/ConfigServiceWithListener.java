package com.alibaba.nacos.example.spring.boot;

/**
 * @description: [description]
 * @author: zxx
 * @createDate: 2024/1/16 22:21
 * @version: [v1.0]
 */
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.client.config.NacosConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.InitBinder;

import javax.annotation.PostConstruct;
import java.util.Properties;

@Service
public class ConfigServiceWithListener {

    @Autowired
    private MyService myService; // 注入其他 Spring 管理的服务

    @PostConstruct
    public void init() throws Exception {
        // Nacos Server 地址
        String serverAddr = "localhost:8848";

        // 配置信息
        String dataId = "example";
        String group = "DEFAULT_GROUP";

        // 初始化 Nacos 配置服务
        Properties properties = new Properties();
        properties.setProperty("serverAddr", serverAddr);
        ConfigService configService = new NacosConfigService(properties);

        // 获取当前配置
        String currentConfig = configService.getConfig(dataId, group, 5000);
        System.out.println("Current Config: " + currentConfig);

        // 添加配置变更监听器
        configService.addListener(dataId, group, new MyConfigChangeListener(myService));
    }
}
