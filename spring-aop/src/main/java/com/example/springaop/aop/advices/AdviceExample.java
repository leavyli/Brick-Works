package com.example.springaop.aop.advices;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author: saino
 * @Description:
 * @date: 2022/5/6 13:03
 */
@Aspect
@Slf4j
@Component
public class AdviceExample {

    /**
     *  after hello() return
     * @param retVal
     */
    @AfterReturning(pointcut = "com.example.springaop.aop.pointcuts.CommonPointcuts.helloController()", returning = "retVal")
    public void doAccessCheck(String retVal){
        log.info("return value is {}", retVal);
    }

    /**
     * advice for HelloController  @getMapping
     */
    @Around("com.example.springaop.aop.pointcuts.CommonPointcuts.helloControllerGetMapping()")
    public Object beforeGetMapping(ProceedingJoinPoint pjp) throws Throwable {
        log.info("before getMapping");
        Object retVal = pjp.proceed();
        log.info("after getMapping");
        //change return value
        return "Hi";
    }

}
