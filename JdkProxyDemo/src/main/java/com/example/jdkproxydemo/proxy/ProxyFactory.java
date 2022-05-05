package com.example.jdkproxydemo.proxy;

import com.example.jdkproxydemo.annotations.MyCustomTransaction;
import com.example.jdkproxydemo.annotations.TransactionalService;
import com.example.jdkproxydemo.handlers.MyTransactionInvocationHandler;
import org.reflections.Reflections;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author: saino
 * @Description:
 * @date:2022/5/5 14:36
 */
public class ProxyFactory {
    private List<MyCustomProxy> beanRegistry;

    public ProxyFactory(Package packageToLookup) {
        Reflections reflections = new Reflections(packageToLookup.getName());
        Set<Class<?>> transctionalServiceClasses = reflections.getTypesAnnotatedWith(TransactionalService.class);

        List<?> beans = instantiateBeans(transctionalServiceClasses);
        beanRegistry = createProxiex(beans);
    }

    private List<MyCustomProxy> createProxiex(List<?> beans) {
        return beans.stream()
                .map(this::createProxy)
                .collect(Collectors.toList());
    }

    private MyCustomProxy createProxy(Object bean) {
        InvocationHandler handler = new MyTransactionInvocationHandler(bean);
        Object proxy = Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), handler);

        return new MyCustomProxy(Arrays.asList(bean.getClass().getInterfaces()), proxy);
    }

    private List<?> instantiateBeans(Set<Class<?>> annotated) {
        return annotated.stream()
                .map(this::instantiateClass)
                .collect(Collectors.toList());
    }

    private Object instantiateClass(Class<?> aClass) {
        try {
            return aClass.getConstructor().newInstance();
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    public <T> T getBean(Class<T> clazz) {
        Object proxy = beanRegistry.stream()
                .filter(p -> p.hasInterface(clazz))
                .findFirst()
                .map(MyCustomProxy::getJdkProxy)
                .orElseThrow(() -> new RuntimeException("No Bean found for class " + clazz));

        return clazz.cast(proxy);
    }
}
