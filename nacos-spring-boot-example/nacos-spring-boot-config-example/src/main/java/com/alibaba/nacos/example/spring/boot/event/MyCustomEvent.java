package com.alibaba.nacos.example.spring.boot.event;

/**
 * @description: [description]
 * @author: zxx
 * @createDate: 2024/1/16 23:14
 * @version: [v1.0]
 */
import org.springframework.context.ApplicationEvent;

public class MyCustomEvent extends ApplicationEvent {

    private String eventData;

    public MyCustomEvent(Object source, String eventData) {
        super(source);
        this.eventData = eventData;
    }

    public String getEventData() {
        return eventData;
    }
}
