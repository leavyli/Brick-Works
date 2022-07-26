package com.example.learnspringjpa.entities;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest(properties = "spring.profiles.active=test")
class BookTest {
    @Autowired
    private RedisTemplate<String, Book> redisTemplate;

//    @Resource(name = "redisTemplate")
//    private ListOperations<String, String> listOps;

    @Test
    void bookRedis() {
        Book book = Book.builder()
                .name("Spring Boot")
                .author("saino")
                .isbn("12345")
                .build();
        redisTemplate.opsForList().leftPush("book", book);
        redisTemplate.opsForList().leftPush("book", book);
    }

    @Test
    void userRedis() {

    }

}