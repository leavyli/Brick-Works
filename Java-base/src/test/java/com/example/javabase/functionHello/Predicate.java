package com.example.javabase.functionHello;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
