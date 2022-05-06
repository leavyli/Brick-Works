package com.example.springaop.aop.advices;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

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
        //获取@GetMapping注解的值
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        var getMappingAnnotation = method.getAnnotation(org.springframework.web.bind.annotation.GetMapping.class);
        var value = getMappingAnnotation.value();
        log.info("@getMapping value is {}", value);

        var declaringClass = method.getDeclaringClass();
        var myAnnotation = declaringClass.getAnnotation(com.example.springaop.annotation.MyAnnotation.class);
        var value2 = myAnnotation.value();
        log.info("@getMapping value is {}", value2);

        Object retVal = pjp.proceed();
        log.info("after getMapping");
        //change return value
        return String.format("Hi %s %s", Arrays.stream(value).collect(Collectors.joining(";")), value2);
    }

}
