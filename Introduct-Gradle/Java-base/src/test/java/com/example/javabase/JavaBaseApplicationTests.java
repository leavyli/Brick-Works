package com.example.javabase;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

class fruit {
}

class apple extends fruit {
}

class banana extends fruit {
}

class orange extends fruit {
}

@SpringBootTest
@Slf4j
class JavaBaseApplicationTests {

    @Test
    void contextLoads() {
    }

    public static <T extends Comparable<? super T>> T max(T a, T b) {
        return a.compareTo(b) > 0 ? a : b;
    }

    static <T> void readValue(T a) {
        log.info("readValue: {}", a);
    }

    @Test
    void test_comparable() {
        Holder<apple> apple = new Holder<>(new apple());
        Holder<? super fruit> fruit = new Holder<>();
//        fruit.setValue(new apple());
        fruit.compare(new apple(), new banana());
//        var  one=fruit.getValue();
//        log.info("one: {}", one);


    }


}
