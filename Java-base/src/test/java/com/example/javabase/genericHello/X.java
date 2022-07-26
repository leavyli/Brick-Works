package com.example.javabase.genericHello;

import java.util.ArrayList;
import java.util.List;

/**
 * Author saino
 * LastModify 2:10
 */
public class X<T> {
    private T t;

    public T m() {
        return t;
    }

    public void m(T arg) {
        this.t = arg;
    }

//    public List<T> f() {
//        return new ArrayList<>();
//    }

    public void f(List<T> arg) {
    }

    public List<? extends T> f() {
        return new ArrayList<T>();
    }

}
