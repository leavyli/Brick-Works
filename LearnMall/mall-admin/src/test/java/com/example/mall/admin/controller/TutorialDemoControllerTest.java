package com.example.mall.admin.controller;

import com.example.mall.admin.model.mongodb.TutorialDemo;
import com.example.mall.admin.repository.mongodb.TutorialDemoRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

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
        var demo2 = new TutorialDemo();
        demo2.setDescription("hoho");
        demo2.setTitle("kao");
        demo2.setPublished(false);
        repository.save(demo2);
        var ret  = repository.findByPublished(false);
        log.info("ret:{}", ret);

    }
}