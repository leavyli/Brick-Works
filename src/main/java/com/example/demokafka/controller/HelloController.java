package com.example.demokafka.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author saino
 * Create 2022/9/13 16:22
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class HelloController {
    private final KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/hello")
    public void sendMessage() {
//        kafkaTemplate.send("HI", "mother fucker!!");
        String msg = "mother fucker!!";
        ProducerRecord<String, String> record = new ProducerRecord<>("HI2", "US", "JP");
//        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("HI", record);
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(record);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>(){

            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("Send Message:= [{}] with offset=[{}]", msg, result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                log.info("Failed Send Message:= [{}] due to:{} ", msg, ex.getMessage());
            }
        });

    }
}
