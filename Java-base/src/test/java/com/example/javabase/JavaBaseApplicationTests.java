package com.example.javabase;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.error.SubarraysShouldHaveSameSize;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.naming.Name;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;



class myCompartor<T> {
    int compare(T o1, T o2) {
        return 0;
    }
}

class myCompartor2<T> {
    private T o1;
    private T o2;
    myCompartor2(T o1, T o2) {
        this.o1 = o1;
        this.o2 = o2;
    }
    T compare(T o1, T o2) {
        return o1;
    }

    T  getO1() {
        return o1;
    }
}


@SpringBootTest
@Slf4j
class JavaBaseApplicationTests {

    @Test
    void contextLoads() {
    }

    static <T> T max(Collection<? extends T> collection, myCompartor<? super T> comparator) {
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

    static <T extends fruit> int fruitCmp(T a, T b) {
        return a.price - b.price;
    }


    @Test
    void test_comparable() {
//        List<fruit> list = Arrays.asList(new apple("apple", 1), new banana("banana", 3), new orange("orange", 2));
        List<apple> list = Arrays.asList(new Jonathan("jonathan", 33), new apple("apple", 1), new apple("apple", 12), new apple("apple", 3));
        List<Jonathan> jonathanList =Arrays.asList(new Jonathan("jonathan", 3), new Jonathan("jonathan", 331), new Jonathan("jonathan", 33));
//        var  r = max(list, (a, b) -> a.price - b.price);
        var r = JavaBaseApplicationTests.<Jonathan>max(jonathanList, new myCompartor<apple>() {
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

        List<? super apple> apples = Arrays.asList(new banana("banana", 1), new banana("banana", 2), new banana("banana", 3));
        ;

        apples.add(new Jonathan("Jonathan", 1));

    }

    @Test
    void test_holder() {
        Holder<? super Integer> holder = new Holder<Integer>();
        // holder.set(123);
        // var s = holder.get();
    }

    @Test
    void test_cmp() {
        Holder<Integer> holder1 = new Holder();
        holder1.setValue(1);
        Holder<Integer> holder2 = new Holder();
        holder2.setValue(22);
//        var myCmp = new cmp<Holder<Integer>>() {
//            @Override
//            public int cmpTo(Holder<Integer> h1, Holder<Integer> h2) {
//                return h1.index - h2.index;
//            }
//
//            public int cmpTo(Holder<Integer> h1, String h2) {
//                log.info("name: {}", name);
//                return 0;
//            }
//        };
//        cmp<Integer> myCmp = (h1, ger> h2) -> h1.index - h2.index;

        var r = Holder.oCmp(holder1, holder2, (h1, h2) -> h1.getValue() - h2.getValue());
        log.info("r: {}", r);

    }

    static void testcm2(myCompartor2<? super Integer> cmp) {
        var r = cmp.compare(1, 2);
        var o1 = cmp.getO1();
        log.info("r: {}, o1:{}", r, o1);
    }

    @Test
    void test_mycmp2() {
        var i = Integer.valueOf(2);
        var j = Integer.valueOf(3);
        testcm2(new myCompartor2<>(i, j));
    }
}


