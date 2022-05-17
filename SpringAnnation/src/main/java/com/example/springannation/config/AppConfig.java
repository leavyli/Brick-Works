package com.example.springannation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

/**
 * Author saino
 * LastModify 10:46
 */
@Configuration
@ComponentScans({
        @ComponentScan(basePackages = "com.example.springannation.Service", excludeFilters = {@Filter(type = FilterType.ANNOTATION, value = Component.class)}),
        @ComponentScan(basePackages = "com.example.springannation.repo"),
        @ComponentScan(basePackages = "com.example.springannation.web"),
})
public class AppConfig {

}
