package com.example.springaop.controller;

import com.example.springaop.annotation.MyAnnotation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: saino
 * @Description:
 * @date: 2022/5/6 12:46
 */
@RestController
@MyAnnotation
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
