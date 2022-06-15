package com.example.javabase;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Author saino
 * LastModify 0:45
 */
@Slf4j
public class ModerJava8Test {

    @Test
    public void test_sort() {
        List<apple> appleList= new ArrayList<>();
        appleList.add(new apple("apple", 1));
        appleList.add(new apple("apple", 5));
        appleList.add(new apple("apple", 3));

        appleList.sort(Comparator.comparing(apple::getPrice));


    }
}
