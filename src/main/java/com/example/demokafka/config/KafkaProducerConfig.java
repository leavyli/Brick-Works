package com.example.demokafka.config;

import com.example.demokafka.protobuf.model.StudentProto;
import io.confluent.kafka.serializers.protobuf.KafkaProtobufSerializer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Author saino
 * Create 2022/9/13 11:09
 */
@Configuration
public class KafkaProducerConfig {
    @Value("${demo-kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${demo-kafka.schema-registry}")
    private String schemRegister;

    @Bean
    @Primary
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);
        return props;
    }

    @Bean
    public Map<String, Object> producerProtoConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                KafkaProtobufSerializer.class);

        props.put("schema.registry.url", schemRegister);
        props.put("auto.register.schemas", "true");
        return props;
    }

    @Bean
    public ProducerFactory<String, StudentProto.Student> producerProtoFactory() {
        return new DefaultKafkaProducerFactory<>(producerProtoConfigs());
    }

    @Bean
    @Primary
    public ProducerFactory<String, String> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    @Primary
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public KafkaTemplate<String, StudentProto.Student> kafkaTemplateProto() {
        return new KafkaTemplate<>(producerProtoFactory());
    }
}
