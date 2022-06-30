package com.example.learnkafka.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author saino
 * LastModify 6:06
 */
@RestController
@Slf4j
public class Hello {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public Hello(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/hello")
    public String hello(@RequestBody String message) {
        kafkaTemplate.send("hello-topic", message);
        return "msg: " + message;
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @KafkaListener(id = "my-hello-li", topics = "hello-topic")
    public void consumeHello(String data) {
        log.info("Consumed message: {}", data);
    }
}
