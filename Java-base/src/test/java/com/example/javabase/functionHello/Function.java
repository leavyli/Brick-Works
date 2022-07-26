package com.example.javabase.functionHello;

@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
}
