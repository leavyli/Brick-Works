package com.example.springannation.config;

import com.example.springannation.config.typeFilter.MyTypeFilter;
import com.example.springannation.domain.OneBean;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;

/**
 * Author saino
 * LastModify 10:46
 */
@Configuration
@ComponentScans({
        @ComponentScan(basePackages = "com.example.springannation.Service", excludeFilters = {
                @Filter(type = FilterType.ANNOTATION, value = Entity.class),
                @Filter(type = FilterType.CUSTOM, value = MyTypeFilter.class),
        }),
        @ComponentScan(basePackages = "com.example.springannation.repo"),
        @ComponentScan(basePackages = "com.example.springannation.web"),
})
public class AppConfig {

        @Bean
        public OneBean oneBean() {
                return new OneBean("it is me oneBean");
        }

}
