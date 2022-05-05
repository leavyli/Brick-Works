package com.example.springaop.PO;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @author: saino
 * @Description:
 * @date:2022/5/5 10:26
 */
public class SimplePojo implements Pojo{

    public static void main(String[] args) {
//        Pojo pojo = new SimplePojo();
//        pojo.foo();
        ProxyFactory factory = new ProxyFactory(new SimplePojo());
        factory.addInterface(Pojo.class);
        factory.addAdvice(new RetryAdvice());

        Pojo pojo = (Pojo)factory.getProxy();
        pojo.foo();
    }

    public void foo() {
        this.bar();
    }

    public void bar() {
        System.out.println("bar logic");
    }
}
