package com.example.javabase.jdkProxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Author saino
 * LastModify 11:46
 */
@Slf4j
public class ProxyEchoService extends Dummy implements InvocationHandler {
//    private Object target;
//    private Class<?> targetClass;
//
//    public ProxyEchoService(Object target, Class<?> cls) {
//        this.target = target;
//        this.targetClass = cls;
//    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        if(EchoService.class.isAssignableFrom(method.getDeclaringClass())) {
            log.info("ProxyEchoService invoke: {}", method.getName());

            EchoService echoService = new DefaultEchoService();
            long starTime = System.currentTimeMillis();
            String result = echoService.echo((String) args[0]);
            long costTime = System.currentTimeMillis() - starTime;
            log.info("echo cost time: {}", costTime);
            return result;
        }
        return null;
//        return method.invoke(target, args);
    }
}
