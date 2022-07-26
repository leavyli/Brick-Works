package com.example.javabase.functionHello;

@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}
