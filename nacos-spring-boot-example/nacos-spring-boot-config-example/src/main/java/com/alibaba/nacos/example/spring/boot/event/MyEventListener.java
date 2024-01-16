package com.alibaba.nacos.example.spring.boot.event;

/**
 * @description: [description]
 * @author: zxx
 * @createDate: 2024/1/16 23:15
 * @version: [v1.0]
 */
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventListener implements ApplicationListener<MyCustomEvent> {

    @Override
    public void onApplicationEvent(MyCustomEvent event) {
        // 在这里处理接收到的自定义事件
        String eventData = event.getEventData();
        System.out.println("Received custom event with data: " + eventData);
    }
}
