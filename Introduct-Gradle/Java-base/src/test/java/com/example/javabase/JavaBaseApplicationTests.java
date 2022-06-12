package com.example.javabase;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.naming.Name;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

class fruit {
    public String name;
    public int price;
    public fruit(String name, int price) {
        this.name = name;
        this.price = price;
    }

}

class apple extends fruit {
    public apple(String name, int price) {
        super(name, price);
    }
}
class Jonathan extends apple {
    public Jonathan(String name, int price) {
        super(name, price);
    }
}

class banana extends fruit {
    public banana(String name, int price) {
        super(name, price);
    }
}

class orange extends fruit {
    public orange(String name, int price) {
        super(name, price);
    }
}

@SpringBootTest
@Slf4j
class JavaBaseApplicationTests {

    @Test
    void contextLoads() {
    }

    static <T> T max(Collection<? extends T> collection, Comparator<? super T> comparator) {
        T candidate = collection.iterator().next();
        for (T t : collection) {
            if (comparator.compare(candidate, t) < 0) {
                candidate = t;
            }
        }
        return candidate;
    }


    static <T> void readValue(T a) {
        log.info("readValue: {}", a);
    }

    static  <T extends fruit> int fruitCmp(T a, T b) {
        return a.price - b.price;
    }

    @Test
    void test_comparable() {
//        List<fruit> list = Arrays.asList(new apple("apple", 1), new banana("banana", 3), new orange("orange", 2));
        List<apple> list = Arrays.asList(new Jonathan("jonathan", 33), new apple("apple", 1), new apple("apple", 12), new apple("apple", 3));
//        var  r = max(list, (a, b) -> a.price - b.price);
        var  r = JavaBaseApplicationTests.max(list, new Comparator<apple>() {
            @Override
            public int compare(apple o1, apple o2) {
                return o1.price - o2.price;
            }
        });
        log.info("r: {} {}", r.name, r.price);
    }

    @Test
    void test_generic() {
        List<banana> fruits = Arrays.asList(new banana("banana", 1), new banana("banana", 2), new banana("banana", 3));
        List<Jonathan> jonathanList = Arrays.asList(new Jonathan("Jonathan", 1), new Jonathan("Jonathan", 2), new Jonathan("Jonathan", 3));
        List<fruit> fruitList = Arrays.asList(new fruit("fruit", 1), new fruit("fruit", 2), new fruit("fruit", 3));
        List<? super apple> apples = Arrays.asList(new banana("banana", 1), new banana("banana", 2), new banana("banana", 3));;

    }




}
