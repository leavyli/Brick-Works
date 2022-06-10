package com.example.javabase;

/**
 * Author saino
 * LastModify 20:56
 */

public class Holder<T> {
    private T value;
    public Holder() {
    }
    public Holder(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
    public Integer compare(T o1, T o2) {
        return -1;
    }
}
