package com.example.demokafka.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demokafka.protobuf.model.StudentProto.Student;

/**
 * Author saino
 * Create 2022/9/13 16:22
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class HelloController {
    private final KafkaTemplate<String, String> kafkaTemplate;
    @Qualifier("kafkaTemplateProto")
    private final KafkaTemplate<String, Student> kafkaProtoTemplate;

    @GetMapping("/hello")
    public void sendMessage() {
//        kafkaTemplate.send("HI", "mother fucker!!");
        String msg = "mother fucker!!";
        ProducerRecord<String, String> record = new ProducerRecord<>("HI3", "US", "JP");
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

    @GetMapping("/student")
    public void getAllStudents() {
        Student student= Student.newBuilder()
                .setStudentId(1)
                .setStudentName("Denis")
                .build();

        ProducerRecord<String, Student> record = new ProducerRecord<>("HI3", "US", student);
        ListenableFuture<SendResult<String, Student>> future = kafkaProtoTemplate.send(record);

        future.addCallback(new ListenableFutureCallback<SendResult<String, Student>>(){

            @Override
            public void onSuccess(SendResult<String, Student> result) {
                log.info("Send Message:= [{}] with offset=[{}]", record, result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                log.info("Failed Send Message:= [{}] due to:{} ", record, ex.getMessage());
            }
        });
    }

}
