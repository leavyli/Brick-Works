package com.example.springannation.config;

import com.example.springannation.SpringAnnationApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author: saino
 * @date: 2022/5/17 10:46
 */
@Slf4j
class AppConfigTest {

    @Test
    public void testAppconfigExclude() {
        var appConfig = new AnnotationConfigApplicationContext(AppConfig.class);
        var beanDefinitionNames= appConfig.getBeanDefinitionNames();
        log.info("beanDefinitionNames ");
        Arrays.stream(beanDefinitionNames).forEach(log::info);
        assertThat(beanDefinitionNames).doesNotContain("anOtherBookService");
    }

    @Test
    public void testApplicationClass() {
        var appConfig = new AnnotationConfigApplicationContext(SpringAnnationApplication.class);
        var beanDefinitionNames= appConfig.getBeanDefinitionNames();
        log.info("beanDefinitionNames ");
        Arrays.stream(beanDefinitionNames).forEach(log::info);
    }



}