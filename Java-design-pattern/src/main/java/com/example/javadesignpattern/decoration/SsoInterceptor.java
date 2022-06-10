package com.example.javadesignpattern.decoration;

/**
 * Author saino
 * LastModify 16:28
 */
public class SsoInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandler(String request, String response, Object handler) {
        // 模拟获取cookie
        String ticket = request.substring(1, 8);
        // 模拟校验
        return ticket.equals("success");
    }
}
