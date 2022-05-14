package com.example.binddata.config;

import com.example.bookstore.convert.AntherStringToBook;
import com.example.bookstore.convert.StringToBook;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcContextConfiguration implements WebMvcConfigurer {


    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToBook());
        registry.addConverter(new AntherStringToBook());
    }
}
