package com.example.javadesignpattern.decoration;

public interface HandlerInterceptor {
    boolean preHandler(String request, String response, Object handler);
}
