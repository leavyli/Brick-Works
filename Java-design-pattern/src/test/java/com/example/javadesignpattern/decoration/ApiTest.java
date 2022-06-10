package com.example.javadesignpattern.decoration;

import org.junit.jupiter.api.Test;

class ApiTest {
    @Test
    public void test_LoginSsoDecorator() {
        LoginSsoDecorator ssoDecorator = new LoginSsoDecorator(new SsoInterceptor() {
        });
        String request = "1successhuahua";

        boolean success = ssoDecorator.preHandler(request, "ewcdqwt40liuiu", "t");
        System.out.println("登录校验：" + request + (success ? " 放行" : " 拦截"));

        String request2 = "1success2huahua";
        boolean success2 = ssoDecorator.preHandler(request2, "ewcdqwt40liuiu", "t");
        System.out.println("登录校验：" + request2 + (success2 ? " 放行" : " 拦截"));
    }

}