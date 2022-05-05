package com.example.jdkproxydemo.handlers;

import com.example.jdkproxydemo.annotations.MyCustomTransaction;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

public class MyTransactionInvocationHandler implements InvocationHandler {
    public Object target;
    private final Class<?> targetClass;

    public MyTransactionInvocationHandler(Object target) {
        this.target = target;
        this.targetClass = target.getClass();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method targetMethod = getOverridedMethod(method);

        return getTransactionalMethod(targetMethod)
                .map(annotation -> handleTransactionalMethod(targetMethod, args, annotation))
                .orElseGet(() -> uncheckInvoke(targetMethod, args));
    }

    private Object handleTransactionalMethod(Method method, Object[] args, MyCustomTransaction annotation) {
        System.out.printf("Opening transaction [%s] with params %s%n", annotation.value(), Arrays.toString(args));

        Object result;
        result = uncheckInvoke(method, args);

        System.out.printf("Committing transaction %s...%n", annotation.value());

        return result;
    }

    /**
     * 调用target实例的对应方法
     * @param method 方法
     * @param args 方法对应的参数
     * @return
     */
    private Object uncheckInvoke(Method method, Object[] args) {
        try {
            return method.invoke(target, args);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Optional<MyCustomTransaction> getTransactionalMethod(Method method) {
        return Optional.ofNullable(method.getAnnotation(MyCustomTransaction.class));
    }

    private Method getOverridedMethod(Method method) throws NoSuchMethodException {
        return targetClass.getDeclaredMethod(method.getName(), method.getParameterTypes());
    }


}
