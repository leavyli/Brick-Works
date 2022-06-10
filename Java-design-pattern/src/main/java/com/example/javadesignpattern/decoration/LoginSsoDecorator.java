package com.example.javadesignpattern.decoration;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author saino
 * LastModify 16:29
 */
@Slf4j
public class LoginSsoDecorator extends SsoDecorator{
    private final static Map<String, String> authMap = new ConcurrentHashMap<>();

    static {
        authMap.put("huahua", "queryUserInfo");
        authMap.put("doudou", "queryUserInfo");
    }

    public LoginSsoDecorator(HandlerInterceptor handlerInterceptor) {
        super(handlerInterceptor);
    }

    @Override
    public boolean preHandler(String request, String response, Object handler) {
        //调用装饰者的方法
        boolean success = super.preHandler(request, response, handler);

        if (!success) return false;
        String userId = request.substring(8);
        String method = authMap.get(userId);
        log.info("模拟单点登录方法访问拦截校验：{} {}", userId, method);
        // 模拟方法校验
        return "queryUserInfo".equals(method);
    }
}
