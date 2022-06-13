package com.example.javabase;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.lang.model.util.TypeKindVisitor14;

/**
 * Author saino
 * LastModify 20:56
 */
interface cmp<T> {
    String name = "mycmp";
    int cmpTo(T h1, T h2);
}

public class Holder<T> {
    private T value;
    private int index;

    public Holder() {
    }

    public Holder(T value) {
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    static <T> int oCmp(T h1, T h2, cmp<? super T> c1) {
        return c1.cmpTo(h1, h2);
    }



}
