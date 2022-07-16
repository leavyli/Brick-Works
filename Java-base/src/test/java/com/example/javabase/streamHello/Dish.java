package com.example.javabase.streamHello;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Author saino
 * LastModify 17:13
 */
@Setter
@Getter
@RequiredArgsConstructor
public class Dish {
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public enum Type {
        MEAT, FISH, OTHER
    }
}
