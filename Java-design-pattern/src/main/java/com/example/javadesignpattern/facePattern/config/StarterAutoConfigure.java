package com.example.javadesignpattern.facePattern.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author saino
 * LastModify 17:22
 */
@Configuration
@ConditionalOnClass(StarterService.class)
@EnableConfigurationProperties(StarterServiceProperties.class)
public class StarterAutoConfigure {

    private final StarterServiceProperties properties;

    public StarterAutoConfigure(StarterServiceProperties properties) {
        this.properties = properties;
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "facetodo.door", value = "enabled", havingValue = "true")
    public StarterService starterService() {
        return new StarterService(properties.getUserStr());
    }
//    @Bean
//    public StarterService starterService() {
//        return new StarterService();
//    }

}
