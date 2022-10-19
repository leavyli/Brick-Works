package com.example.demokafka;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * Author saino
 * Create 2022/9/13 12:24
 */

@SpringBootTest
@Slf4j
public class KafkaDemoTests {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;






}
