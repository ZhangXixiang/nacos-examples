package com.alibaba.nacos.example.spring.boot.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.example.spring.boot.YourStaticClass;
import com.alibaba.nacos.example.spring.boot.event.MyEventPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("config")
public class ConfigController {

    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private String useLocalCache;

    @Autowired
    private MyEventPublisherService eventPublisherService;

    @RequestMapping(value = "/get", method = GET)
    @ResponseBody
    public String get() {

        YourStaticClass.setSomeProperty(useLocalCache);

        System.out.println("YourStaticClass.getSomeProperty=="+YourStaticClass.getSomeProperty());

        eventPublisherService.publishCustomEvent(useLocalCache);

        System.out.println("eventPublisherService="+useLocalCache);

        return useLocalCache;
    }
}