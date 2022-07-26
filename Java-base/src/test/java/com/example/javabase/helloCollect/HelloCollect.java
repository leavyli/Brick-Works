package com.example.javabase.helloCollect;

import com.example.javabase.streamHello.Dish;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

import static java.util.stream.Collectors.*;

/**
 * Author saino
 * LastModify 18:32
 */
@Slf4j
public class HelloCollect {

    @Test
    void testSomeCollect() {
        var menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT), new Dish("beef", false, 700, Dish.Type.MEAT), new Dish("chicken", false, 400, Dish.Type.MEAT), new Dish("french fries", true, 530, Dish.Type.OTHER), new Dish("rice", true, 350, Dish.Type.OTHER), new Dish("season fruit", true, 120, Dish.Type.OTHER), new Dish("pizza", true, 550, Dish.Type.OTHER), new Dish("prawns", false, 300, Dish.Type.FISH), new Dish("salmon", false, 450, Dish.Type.FISH));

        Comparator<Dish> dishCaloriesComparator = Comparator.comparing(Dish::getCalories);
        Optional<Dish> dish = menu.stream().collect(maxBy(dishCaloriesComparator));
        Optional<Dish> dish2 = menu.stream().collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));

        if (dish.isPresent()) {
            log.info("dish:{} calories:{}", dish.get().getName(), dish.get().getCalories());
        }
        if (dish2.isPresent()) {
            log.info("dish:{} calories:{}", dish2.get().getName(), dish2.get().getCalories());
        }


        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
        int totalCalories2 = menu.stream().collect(reducing(0, Dish::getCalories, (d1, d2) -> d1 + d2));
        log.info("totalCalories:{} totalColories2:{}", totalCalories, totalCalories2);

        var averagingCalories = menu.stream().collect(averagingInt(Dish::getCalories));
        log.info("averagingCalories:{}", averagingCalories);

        var statisticsCalories = menu.stream().collect(summarizingDouble(Dish::getCalories));
        log.info("statisticsCalories :{}", statisticsCalories);


        var dishByType = menu.stream().collect(groupingBy(Dish::getType));
        log.info("dishByType:{}", dishByType);

        var dishByTypeAndFilter = menu.stream().collect(groupingBy(
                Dish::getType,
                filtering(d -> d.getCalories() > 500, toList()))
        );

        log.info("dishByTypeAndFilter:{}", dishByTypeAndFilter);

        var dishByMap = menu.stream().filter(d -> d.getCalories() > 500).collect(groupingBy(
                Dish::getType,
                mapping(d -> d.getName() + ":" + d.getCalories(), toList()))
        );
        log.info("dishByMap:{}", dishByMap);
    }
}

