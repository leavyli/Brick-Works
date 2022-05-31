package com.example.javadesignpattern.adapterPattern.mq.adapter;

import com.example.javadesignpattern.adapterPattern.mq.CreateAccount;
import com.example.javadesignpattern.adapterPattern.mq.OrderMq;
import com.example.javadesignpattern.adapterPattern.service.InsiderOrderService;
import com.example.javadesignpattern.adapterPattern.service.OrderService;
import com.example.javadesignpattern.adapterPattern.service.POPOrderAdapterServiceImpl;
import com.example.javadesignpattern.adapterPattern.service.POPOrderService;
import com.example.javadesignpattern.adapterPattern.service.adapter.OrderAdapterService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.HashMap;

@SpringBootTest
@Slf4j
class MQAdapterTest {
    @Autowired
    POPOrderService popOrderService;
    @Autowired
    OrderService orderService;
    @Test
    public void test_MQAdater() throws JsonProcessingException {
        var creatAccount = new CreateAccount();
        creatAccount.setNumber("123");
        creatAccount.setAddress("g省");
        creatAccount.setDesc("create account");
        creatAccount.setAccountDate(LocalDateTime.parse("2019-03-27T10:15:30"));

        var link01 = new HashMap<String, String>();
        link01.put("userId", "number");
        link01.put("bizId", "number");
        link01.put("bizTime", "accountDate");
        link01.put("desc", "desc");

        var objectMapper = new ObjectMapper();
        var rebateInfo01 = MQAdapter.filter(objectMapper.writeValueAsString(creatAccount), link01);

        log.info("mq.CreatAccount适配前:{}", creatAccount);
        log.info("mq.CreateAccount适配后:{}", rebateInfo01);

        OrderMq orderMq = new OrderMq();
        orderMq.setUid("100001");
        orderMq.setSku("10928092093111123");
        orderMq.setOrderId("100000890193847111");
        orderMq.setCreateOrderDate(LocalDateTime.now());
        HashMap<String, String> link02 = new HashMap<>();
        link02.put("userId", "uid");
        link02.put("bizId", "orderId");
        link02.put("bizTime", "createOrderDate");

        var rebateInfo02 = MQAdapter.filter(objectMapper.writeValueAsString(orderMq), link02);

        log.info("mq.OrderMq适配前:{}", orderMq);
        log.info("mq.OrderMq适配后:{}", rebateInfo02);

    }
    @Test
    public void test_itfAdapter() {
        OrderAdapterService popOrderAdapterService = new POPOrderAdapterServiceImpl(popOrderService);
        System.out.println("判断⾸首单，接⼝口适配(POP)：" +
                popOrderAdapterService.isFirst("100001"));
        OrderAdapterService insideOrderService = new InsiderOrderService(orderService);
        System.out.println("判断⾸首单，接⼝口适配(⾃自营)：" +
                insideOrderService.isFirst("100001"));
    }

}