package com.alibaba.nacos.example.spring.boot.event;

/**
 * @description: [description]
 * @author: zxx
 * @createDate: 2024/1/16 23:14
 * @version: [v1.0]
 */
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class MyEventPublisherService {

    private final ApplicationEventPublisher eventPublisher;

    public MyEventPublisherService(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void publishCustomEvent(String eventData) {
        MyCustomEvent customEvent = new MyCustomEvent(this, eventData);
        eventPublisher.publishEvent(customEvent);
    }
}
