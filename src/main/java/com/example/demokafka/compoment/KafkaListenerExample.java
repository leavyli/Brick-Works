package com.example.demokafka.compoment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Author saino
 * Create 2022/9/13 16:11
 */
@Component
@Slf4j
public class KafkaListenerExample {

    @KafkaListener(topics = {"HI"}, id = "we are demo")
    void listener(String data) {
        log.info(data);
    }
}
