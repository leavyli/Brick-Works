package com.example.javabase.controller;

import com.example.javabase.dto.PersonDto;
import com.example.javabase.model.Person;
import com.example.javabase.service.TransferService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author saino
 * LastModify 23:19
 */
@RestController
@Slf4j
@RequiredArgsConstructor
public class HelloController {
    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String hello(@RequestBody List<Person> person) {
        log.info("hello: {}", person);
        return "hello, world";
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.POST)
    public String hello2(@RequestBody PersonDto personDtos) {
        log.info("hello: {}", personDtos);
        return "hello, world";
    }
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        log.info("hello: {}", "test");
        return "hello, world";
    }
}
