package com.example.springaop.aop.advices;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author: saino
 * @Description:
 * @date: 2022/5/6 14:15
 */
@Aspect
@Component
@Slf4j
public class MyAspect {
    @Before("@within(com.example.springaop.annotation.MyAnnotation) && execution(public !static * *(..))")
    public void adviceAtWithin(JoinPoint thisJoinPoint) {
        log.info("[@within] " + thisJoinPoint);
    }

//    @Before("@annotation(com.example.springaop.annotation.MyAnnotation) && execution(public !static * *(..))")
//    public void adviceAtTarget(JoinPoint thisJoinPoint) {
//        log.info("[@target] " + thisJoinPoint);
//    }
}
