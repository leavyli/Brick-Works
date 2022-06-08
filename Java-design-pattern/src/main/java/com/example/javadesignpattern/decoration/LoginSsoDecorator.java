package com.example.javadesignpattern.decoration;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author saino
 * LastModify 16:29
 */
public class LoginSsoDecorator implements SsoInterceptor{
    private final static Map<String, String> authMap = new ConcurrentHashMap<>();

    static {
        authMap.put("huahua", "queryUserInfo");
        authMap.put("doudou", "queryUserInfo");
    }

    @Override
    public boolean preHandler(String request, String response, Object handler) {
        // 模拟获取cookie
        String ticket = request.substring(1, 8);
        // 模拟校验
        boolean success = ticket.equals("success");

        if (!success) return false;

        String userId = request.substring(8);
        String method = authMap.get(userId);

        // 模拟方法校验
        return "queryUserInfo".equals(method);
    }
}
