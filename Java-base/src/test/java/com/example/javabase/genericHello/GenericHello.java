package com.example.javabase.genericHello;

import com.example.javabase.functionHello.A;
import com.example.javabase.functionHello.B;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Author saino
 * LastModify 6:39
 */
@Slf4j
public class GenericHello {
    public static <T> T getList(List<? extends T> list) {
        return list.get(0);
    }

    public static <T> void addList(List<? super T> list, T t) {
        list.add(t);
    }

    @Test
    void testGetList() {
        List<? super A> list = new ArrayList<>();
//        list.add(new B());
        addList(list, new B());
        list.add(new A());
        var s = getList(list);
        log.info("s: {} {}", s, s.getClass());
    }

    public static void overloadedMethod(Object o) {
        log.info("overloadedMethod(Object)");
    }

    public static void overloadedMethod(String s) {
        log.info("overloadedMethod(String)");
    }

    public static void overloadedMethod(Integer i) {
        log.info("overloadedMethod(Integer)");
    }

    public static <T> void genericMethod(T t) {
        overloadedMethod(t);
    }

    @Test
    void testOverloadedMethod() {
        GenericHello.<String>genericMethod("abc");
    }

    @Test
    void testStack() {
        var statck = new Stack<Number>();
        Integer n = 2;
        StackAddElement(statck, n);
    }

    public static <T, R extends T> void StackAddElement(Stack<? super T> stack, R el) {
        stack.add(el);
    }
}
