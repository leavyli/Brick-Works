package com.example.javabase.jdkProxy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class EchoServiceTest {
    @Test
    void jdkProxyDemo() {
        var classLoader = Thread.currentThread().getContextClassLoader();
        var proxy = Proxy.newProxyInstance(classLoader, new Class[]{EchoService.class}, new ProxyEchoService());

        EchoService echoService = (EchoService) proxy;
        echoService.echo("hello, world");
    }

}