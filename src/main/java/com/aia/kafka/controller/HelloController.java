package com.aia.kafka.controller;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author FM
 * @Description
 * @create 2021-02-01 22:53
 */
@RestController
@RequestMapping("/kafka")
public class HelloController {

    @Autowired
    private ApplicationContext context;

    @GetMapping("/hello")
    public String hello(){
        KafkaConsumer bean = context.getBean(KafkaConsumer.class);
        System.out.println(bean);
        return "hello";
    }

}
