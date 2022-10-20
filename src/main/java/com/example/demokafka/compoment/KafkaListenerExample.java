package com.example.demokafka.compoment;

import com.google.protobuf.DynamicMessage;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static com.example.demokafka.protobuf.model.StudentProto.Student;

/**
 * Author saino
 * Create 2022/9/13 16:11
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaListenerExample {

    @KafkaListener(topics = {"HI2"}, id = "we are demo")
    void listener(String data) {
        log.info(data);
    }

    @KafkaListener(topics = {"HI3"}, id = "protobuf-demo", containerFactory = "kafkaListenerProtoContainerFactory")
    void listenerStudent(ConsumerRecord<String, DynamicMessage> record) throws InvalidProtocolBufferException {
        var s = Student.parseFrom(record.value().toByteArray());
        log.info("studentName: {}", s.getStudentName());
    }
}
