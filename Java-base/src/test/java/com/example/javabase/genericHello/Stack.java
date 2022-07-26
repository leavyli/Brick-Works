package com.example.javabase.genericHello;

/**
 * Author saino
 * LastModify 23:50
 */
public class Stack<E> {
    private Object[] elementData;
    private int DEFAULT_CAP = 512;
    // 元素个数
    protected int size;

    public Stack() {
        elementData = new Object[DEFAULT_CAP];
    }

    public Stack(int size) {
        elementData = new Object[size];
        DEFAULT_CAP = size;
    }


    public boolean add(E element) {
        if (size >= 512) {
            return false;
        }

        elementData[size] = element;
        size++;
        return true;
    }

    @SuppressWarnings("unchecked")
    public E get(int i) {
        return (E) elementData[i];
    }


}
