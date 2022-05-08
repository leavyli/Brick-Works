package com.example.implementingcontroller.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;

/*
 * @author: saino
 * @Description:
 * @date: 2022/5/8 14:48
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World" + new Time(System.currentTimeMillis());
    }
}
