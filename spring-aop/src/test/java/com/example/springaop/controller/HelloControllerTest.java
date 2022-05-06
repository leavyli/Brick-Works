package com.example.springaop.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: saino
 * @Description:
 * @date: 2022/5/6 12:48
 */
@SpringBootTest
class HelloControllerTest {
    @Autowired
    HelloController  helloController;

    @Test
    void hello() {
        String result = helloController.hello("world");
        assertEquals("Hi /hello MyCustomAnnotation", result);
    }
}