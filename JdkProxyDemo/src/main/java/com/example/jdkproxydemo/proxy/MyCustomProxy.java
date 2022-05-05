package com.example.jdkproxydemo.proxy;

import java.util.List;

/**
 * @author: saino
 * @Description:
 * @date:2022/5/5 14:59
 */
public class MyCustomProxy {
    private List<Class<?>> interfaces;
    private Object proxy;

    public MyCustomProxy(List<Class<?>> interfaces, Object proxy) {
        this.interfaces = interfaces;
        this.proxy = proxy;
    }

    public Object getJdkProxy() {
        return proxy;
    }

    public boolean hasInterface(Class<?> clazz) {
        return interfaces.contains(clazz);
    }

}
