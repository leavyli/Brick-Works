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

    @Test
    void testTakeAndDrop() {
        var menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );

//        menu.stream().takeWhile((dish) -> dish.getCalories() < 500).forEach(dish -> log.info("{} {}", dish.getName(), dish.getCalories()));
        menu.stream().dropWhile((dish) -> dish.getCalories() < 500).forEach(dish -> log.info("{} {}", dish.getName(), dish.getCalories()));

    }

    @Test
    void testMapAndFlatMap() {
        var words = Arrays.asList("hello", "world");
        var result = words.stream().map((word) -> word.split("")).collect(Collectors.toList());
        result.forEach((el) -> log.info("{}", el));

        log.info("-----------------------------------------------------");
        var result2 = words.stream().map((word) -> word.split("")).flatMap(Arrays::stream).collect(Collectors.toList());
        result2.forEach((el) -> log.info("{}", el));

    }

    @Test
    void testMapPair() {
        var numbers1 = Arrays.asList(1, 2, 3);
        var numbers2 = Arrays.asList(6, 7, 8, 9, 10);

        var result = numbers1.stream().map((i) -> numbers2.stream().map((j) -> new int[]{i, j})).collect(Collectors.toList());
        log.info("{}", result);

        var result2 = numbers1.stream().flatMap((i) -> numbers2.stream().map((j) -> new int[]{i, j})).collect(Collectors.toList());
        log.info("{}", result2);
    }

    @Test
    void testMapSum() {
        var numbers1 = Arrays.asList(1, 2, 3);
        var numbers2 = Arrays.asList(6, 7, 8, 9, 10);
        var result = numbers1.stream()
                .flatMap((i) -> numbers2.stream().filter((j) -> (j + i) == 10).map((j) -> new PairSum<>(i, j)))
                .collect(Collectors.toList());
        result.forEach((el) -> log.info("{}", el));

    }


}
