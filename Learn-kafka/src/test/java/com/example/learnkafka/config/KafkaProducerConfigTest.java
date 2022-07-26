package com.example.learnkafka.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;


@SpringBootTest
class KafkaProducerConfigTest {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Test
    void sendMsg() {
        sendMsg("test", "Hello Kafka");
    }

    void sendMsg(String topic, String message) {
        kafkaTemplate.send(topic, message);

//        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, message);
//
//        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
//            @Override
//            public void onSuccess(SendResult<String, String> result) {
//                System.out.println("Sent message=[" + message +
//                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
//            }
//
//            @Override
//            public void onFailure(Throwable ex) {
//                System.out.println("Unable to send message=["
//                        + message + "] due to : " + ex.getMessage());
//            }
//        });

    }

    //    @KafkaListener(topics = "test", groupId = "group-id")
    public void listen(String message) {
        System.out.println("Received Messasge in group - group-id: " + message);
    }


}