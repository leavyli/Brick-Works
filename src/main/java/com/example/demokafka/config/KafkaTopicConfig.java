package com.example.demokafka.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.Map;

/**
 * Author saino
 * Create 2022/9/13 12:01
 */
@Configuration
public class KafkaTopicConfig {
    @Value("${demo-kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public NewTopic demoKafka() {
        return TopicBuilder.name("first-demo-kafka")
                .build();
    }

    @Bean
    public KafkaAdmin admin() {
        return new KafkaAdmin(Map.of(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers));
    }
}
