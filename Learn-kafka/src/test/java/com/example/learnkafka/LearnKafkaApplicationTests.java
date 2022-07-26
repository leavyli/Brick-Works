package com.example.learnkafka;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class LearnKafkaApplicationTests {

    static void config(Map<String, ?> map) {
    }

    @Test
    void contextLoads() {
    }

    @Test
    void testkk() {
        Map<String, Long> map = new HashMap<>();
        map.put("a", 1L);
    }

}
