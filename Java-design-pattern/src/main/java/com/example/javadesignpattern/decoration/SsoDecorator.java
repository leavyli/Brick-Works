package com.example.javadesignpattern.decoration;

/**
 * Author saino
 * LastModify 16:51
 */
public abstract class SsoDecorator implements HandlerInterceptor{
    private HandlerInterceptor handlerInterceptor;

    private SsoDecorator(){}

    public SsoDecorator(HandlerInterceptor handlerInterceptor) {
        this.handlerInterceptor = handlerInterceptor;
    }

    @Override
    public boolean preHandler(String request, String response, Object handler) {
        return handlerInterceptor.preHandler(request, response, handler);
    }
}
