package com.example.binddata.config;

import com.example.bookstore.convert.StringToBook;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: saino
 * @date: 2022/5/9 17:22
 */
@Configuration
public class WebMvcContextConfiguration implements WebMvcConfigurer {


    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToBook());
    }
}
