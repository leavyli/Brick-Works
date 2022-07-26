package com.example.javabase.functionHello;

/**
 * Author saino
 * LastModify 1:01
 */
public class Apple {
    private int weight;

    public Apple(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "weight: " + weight;
    }

}
