package com.example.demokafka.compoment;

import com.example.demokafka.protobuf.model.StudentProto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static com.example.demokafka.protobuf.model.StudentProto.*;

/**
 * Author saino
 * Create 2022/9/13 16:11
 */
@Component
@Slf4j
public class KafkaListenerExample {

    @KafkaListener(topics = {"HI2"}, id = "we are demo")
    void listener(String data) {
        log.info(data);
    }

    @KafkaListener(topics = {"HI3"}, id = "protobuf-demo")
    void listenerStudent(String data) {
        log.info(data);
    }
}
