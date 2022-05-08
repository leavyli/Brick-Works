package com.example.implementingcontroller.config;

import com.example.implementingcontroller.web.controller.IndexController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import java.util.HashMap;
import java.util.Properties;

/**
 * @author: saino
 * @Description:
 * @date: 2022/5/8 14:22
 */
@EnableWebMvc
@Configuration
public class WebMvcContextConfiguration {
    @Bean
    public IndexController indexController() {
        return new IndexController();
    }

    @Bean
    public SimpleUrlHandlerMapping simpleUrlHandlerMapping() {
        var mappings = new HashMap<String, Object>();
        mappings.put("/index", indexController());
        var simpleUrlHandlerMapping = new SimpleUrlHandlerMapping();
        simpleUrlHandlerMapping.setUrlMap(mappings);
        return simpleUrlHandlerMapping;
    }
}
