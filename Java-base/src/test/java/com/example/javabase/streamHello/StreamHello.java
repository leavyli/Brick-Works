package com.example.javabase.streamHello;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Author saino
 * LastModify 17:13
 */
@Slf4j
public class StreamHello {
    @Test
    void testStream() {
        var menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("season fruit", true, 1200, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );

        var vegetarianMenu = menu.stream()
                .filter(Dish::isVegetarian)
//                .map(Dish::getName)
                .collect(Collectors.toMap(Dish::getName, Dish::getCalories, (existing, replacement) -> existing));
//                .collect(Collectors.toConcurrentMap(Dish::getName, Dish::getCalories, (s, a) -> s));
        log.info("{}", vegetarianMenu);

    }
}
