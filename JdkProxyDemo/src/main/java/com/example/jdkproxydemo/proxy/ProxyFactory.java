package com.example.jdkproxydemo.proxy;

import com.example.jdkproxydemo.annotations.TransactionalService;
import com.example.jdkproxydemo.handlers.MyTransactionInvocationHandler;
import com.example.jdkproxydemo.utilities.ClassScanner;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProxyFactory {
    private List<MyCustomProxy> beanRegistry;

    public ProxyFactory(Package packageToLookup) {
        //获取所有带有@TransactionalService注解的类
        Set<Class<?>> transctionalServiceClasses = ClassScanner.findAllAnnotatedClassesInPackage(packageToLookup.getName(), TransactionalService.class);

        List<?> beans = instantiateBeans(transctionalServiceClasses);
        beanRegistry = createProxiex(beans);
    }

    /**
     * 创建代理
     * @param beans 实例化的bean
     * @return List<MyCustomProxy>
     */
    private List<MyCustomProxy> createProxiex(List<?> beans) {
        return beans.stream()
                .map(this::createProxy)
                .collect(Collectors.toList());
    }

    /**
     * 把类实例化成代理实例
     * @param bean 类实例
     * @return MyCustomProxy
     */
    private MyCustomProxy createProxy(Object bean) {
        InvocationHandler handler = new MyTransactionInvocationHandler(bean);
        Object proxy = Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), handler);

        return new MyCustomProxy(Arrays.asList(bean.getClass().getInterfaces()), proxy);
    }

    /**
     * 实例化所有带有@TransactionalService注解的类
     * @param annotated 注解类Set
     * @return List<Object>
     */
    private List<?> instantiateBeans(Set<Class<?>> annotated) {
        return annotated.stream()
                .map(this::instantiateClass)
                .collect(Collectors.toList());
    }

    /**
     * 实例化类
     * @param aClass 类
     * @return Object
     */
    private Object instantiateClass(Class<?> aClass) {
        try {
            return aClass.getConstructor().newInstance();
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     *
     * @param clazz
     * @return 对应的类的实例
     */
    public <T> T getBean(Class<T> clazz) {
        Object proxy = beanRegistry.stream()
                .filter(p -> p.hasInterface(clazz))
                .findFirst()
                .map(MyCustomProxy::getJdkProxy)
                .orElseThrow(() -> new RuntimeException("No Bean found for class " + clazz));

        return clazz.cast(proxy);
    }
}
