package com.example.mall.admin.controller;

import com.example.mall.admin.model.TutorialDemo;
import com.example.mall.admin.repository.TutorialDemoRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.PostConstruct;

@SpringBootTest
@ActiveProfiles("test")
@Slf4j
class TutorialDemoControllerTest {
    @Autowired
    private TutorialDemoRepository repository;

    @Test
    void createTutorialDemo() {
        var demo = new TutorialDemo();
        demo.setDescription("hoho");
        demo.setTitle("kao");
        demo.setPublished(false);
        repository.save(demo);
        var ret  = repository.findByPublished(false);
        log.info("ret:{}", ret);

    }
}