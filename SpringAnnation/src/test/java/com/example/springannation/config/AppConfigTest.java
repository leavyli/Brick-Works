package com.example.springannation.config;

import com.example.springannation.SpringAnnationApplication;
import com.example.springannation.domain.OneBean;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.Resource;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author: saino
 * @date: 2022/5/17 10:46
 */
@SpringBootTest
@Slf4j
class AppConfigTest {
    @Autowired
    private OneBean oneBean;

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testAppconfigExclude() {
        var appConfig = new AnnotationConfigApplicationContext(AppConfig.class);
        var beanDefinitionNames= appConfig.getBeanDefinitionNames();
        log.info("beanDefinitionNames ");
        Arrays.stream(beanDefinitionNames).forEach(log::info);
        assertThat(beanDefinitionNames).doesNotContain("anOtherBookService");
    }

    @Test
    public void testAppconfigCustomExclude() {
        var appConfig = new AnnotationConfigApplicationContext(AppConfig.class);
        var beanDefinitionNames= appConfig.getBeanDefinitionNames();
        log.info("beanDefinitionNames ");
        Arrays.stream(beanDefinitionNames).forEach(log::info);
        assertThat(beanDefinitionNames).doesNotContain("customExcludeService");

    }

    @Test
    public void testGetOneBean() {
        var  newOneBean =  new  OneBean("me me");
        assertThat(oneBean).isNotEqualTo(newOneBean);

        var newOneBean2 =  applicationContext.getBean(OneBean.class);
        assertThat(oneBean).isEqualTo(newOneBean2);
    }

}