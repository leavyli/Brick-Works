package com.example.javadesignpattern.adapterPattern.mq.adapter;

import com.example.javadesignpattern.adapterPattern.mq.CreateAccount;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.HashMap;

@SpringBootTest
@Slf4j
class MQAdapterTest {
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

        var objectMapper =  new ObjectMapper();
        var jsonStr = objectMapper.writeValueAsString(creatAccount);

        var rebateInfo01 = MQAdapter.filter(jsonStr, link01);

        log.info("rebateInfo01:{}", rebateInfo01);

        log.info("creatAccount:{}", creatAccount);
    }

}