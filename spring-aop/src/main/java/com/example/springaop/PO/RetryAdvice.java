package com.example.springaop.PO;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author: saino
 * @Description:
 * @date:2022/5/5 10:32
 */
public class RetryAdvice implements MethodBeforeAdvice {
//    public class RetryAdvice implements Advice{
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("before");
    }

//    @Override
//    public Object invoke(MethodInvocation invocation) throws Throwable {
//        return null;
//    }
}
