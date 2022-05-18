package com.example.springannation.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Author saino
 * LastModify 10:12
 */
@Configuration
@ConditionalOnProperty(prefix = "hello", name = "enabled", havingValue = "true")
public class HelloConditionalConfig {
}
