package com.example.javadesignpattern.adapterPattern.service;

import com.example.javadesignpattern.adapterPattern.mq.OrderMq;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

/**
 * Author saino
 * LastModify 10:18
 */
@Slf4j
public class OrderMqService {
    public void onMessage(String message) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        var mq = objectMapper.readValue(message, OrderMq.class);
        log.info("接收到消息：{}", mq);
        mq.getOrderId();
        mq.getSku();

        log.info("do some  work...");
    }
}
