package com.example.javadesignpattern.facePattern.controller;

import com.example.javadesignpattern.facePattern.config.StarterService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class queryUserInfoTest {
    @Autowired
    StarterService starterService;

    @Test
    void queryUserInfo() {
        var userStr= starterService.getUserStr();
        log.info("userStr={}",userStr);

    }
}