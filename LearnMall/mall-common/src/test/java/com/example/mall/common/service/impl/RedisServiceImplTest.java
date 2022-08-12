package com.example.mall.common.service.impl;

import com.example.mall.common.service.RedisService;
import com.example.mall.common.service.impl.someClass.A;
import com.example.mall.common.service.impl.someClass.B;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
@Slf4j
class RedisServiceImplTest {
    @Autowired
    private RedisService<String, String> redisService;
    @Autowired
    private RedisService<String, Integer> redisService2;

    @Autowired
    private RedisService<String, A> redisService3;

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void testSome(){
        var r1 = applicationContext.getBeansOfType(RedisService.class);
        r1.forEach((k, v) -> log.info("{}:{}", k, v));

    }

    @Test
    void set() {
    }

    @Test
    void testList() {
        redisService3.lPush("list", new A("dck", Long.parseLong("1")));
        redisService3.lPush("list", new B("edck", Long.parseLong("1"), "dck"));

        var r = redisService3.lRange("list", 0, -1);
        r.forEach((v) -> log.info("{}", v.getName()));
    }

    @Test
    void get() {
        redisService.set("abc", "123");
        redisService2.set("bcd", 456);
        var  v  = redisService2.getRedisTemplate().opsForValue();
        var r2 = v.get("abc");
        log.info("{}", r2);
    }

    @Test
    void del() {
    }
}