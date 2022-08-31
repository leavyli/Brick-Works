package com.example.javabase.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Author saino
 * LastModify 16:46
 */
@Aspect
@Slf4j
@Component
public class HelloControllerAop {
    @Pointcut("execution(* com.example.javabase.controller.*.hello2(..))")
    public void hello2Point(){

    }

    @Before("hello2Point() && args(com.example.javabase.dto.PersonDto)")
    public void before() {
        log.info("before");
    }
}
