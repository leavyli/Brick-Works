package com.example.javadesignpattern.adapterPattern.service;

import com.example.javadesignpattern.adapterPattern.mq.CreateAccount;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;

/**
 * Author saino
 * LastModify 10:18
 */
public class CreateAccountMqService {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(CreateAccountMqService.class);

    public void onMessage(String message) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        CreateAccount mq = objectMapper.readValue(message, CreateAccount.class);
        log.info("接收到消息：{}", mq);
        mq.getNumber();
        mq.getAccountDate();

        log.info("do some  work...");
    }
}
