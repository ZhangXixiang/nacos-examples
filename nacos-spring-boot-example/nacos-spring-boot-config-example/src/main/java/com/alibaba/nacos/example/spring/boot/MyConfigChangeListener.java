package com.alibaba.nacos.example.spring.boot;

/**
 * @description: [description]
 * @author: zxx
 * @createDate: 2024/1/16 22:22
 * @version: [v1.0]
 */
import com.alibaba.nacos.api.config.listener.Listener;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.Executor;

public class MyConfigChangeListener implements Listener {

    private final MyService myService;

    @Autowired
    public MyConfigChangeListener(MyService myService) {
        this.myService = myService;
    }

    @Override
    public Executor getExecutor() {
        return null; // 使用默认的 Executor
    }

    @Override
    public void receiveConfigInfo(String configInfo) {
        // 在这里处理配置变更的逻辑，调用 MyService 中的方法
        myService.processConfigChange(configInfo);
    }
}
