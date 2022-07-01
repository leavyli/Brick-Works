package com.example.javabase;

import java.util.Comparator;

/**
 * Author saino
 * LastModify 8:50
 */
public final class Wrapper<T> {
    final T theObject;

    public Wrapper(T t) {
        theObject = t;
    }

    public T getWrapper() {
        return theObject;
    }

    public <V extends Wrapper<? extends Comparable<T>>> Comparator<V> comparator() {
        return this.new WrapperComparator<V>();
    }

    private final class WrapperComparator<W extends Wrapper<? extends Comparable<T>>> implements Comparator<W> {
        public int compare(W lhs, W rhs) {
            return lhs.theObject.compareTo((T) (rhs.theObject));
        }
    }
}
