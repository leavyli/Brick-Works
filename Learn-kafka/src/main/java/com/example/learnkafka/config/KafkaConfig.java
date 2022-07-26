package com.example.learnkafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * Author saino
 * LastModify 11:41
 */
@Configuration
public class KafkaConfig {
    @Bean
    public NewTopic topic1() {
        return TopicBuilder.name("reflectoring-1").build();
    }

    @Bean
    public NewTopic myHello() {
        return TopicBuilder.name("my-hello").build();
    }
}
