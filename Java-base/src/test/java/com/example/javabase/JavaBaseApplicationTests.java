package com.example.javabase;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


class myCompartor<T> {
    int compare(T o1, T o2) {
        return 0;
    }
}

class myCompartor2<T> {
    private final T o1;
    private final T o2;

    myCompartor2(T o1, T o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    T compare(T o1, T o2) {
        return o1;
    }

    T getO1() {
        return o1;
    }
}


@SpringBootTest
@Slf4j
class JavaBaseApplicationTests {
    static void useD(D<? extends B> d) {
//        var box = new Box<>(123);
//        box.setT(234);

    }

    static void useMyCmp(List<? extends B> list, myCmp<? super B> cmp) {
        var a1 = list.get(0);
        var a2 = list.get(1);

        cmp.cmpTo(a1, a2);
        cmp.nothing(a1);
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

    static <T extends Comparable<T>> void testcm2(myCompartor2<T> cmp) {
//        var r = cmp.compareTo(1, 2);
        var o1 = cmp.getO1();
        log.info("r: {}, o1:{}", o1);
    }

    @Test
    void testBox() {
        Box<B> box = new Box<>(new B());
        box.setT(new C());
        box.hi(new C());
    }

    @Test
    void testD() {
        List<B> list = new ArrayList<>();
        ArrayList<B> list2 = new ArrayList<>();
        var a1 = new A();
        var b1 = new B();
        var c1 = new C();
        list.add(b1);
        list.add(c1);

//        list2.add(a1);

        List<? extends B> list3 = list;
        list.addAll(list2);
    }

    @Test
    void testMycmp() {
        List<B> list = new ArrayList<>();
        var b1 = new B();
        var c1 = new C();
        list.add(b1);
        list.add(c1);

        useMyCmp(list, new myCmp<A>() {
            @Override
            public int cmpTo(A h1, A h2) {
                return h1.hashCode() - h2.hashCode();
            }
        });
    }

    @Test
    void contextLoads() {
    }

    @Test
    void test_comparable() {
//        List<fruit> list = Arrays.asList(new apple("apple", 1), new banana("banana", 3), new orange("orange", 2));
        List<apple> list = Arrays.asList(new Jonathan("jonathan", 33), new apple("apple", 1), new apple("apple", 12), new apple("apple", 3));
        List<Jonathan> jonathanList = Arrays.asList(new Jonathan("jonathan", 3), new Jonathan("jonathan", 331), new Jonathan("jonathan", 33));
//        var  r = max(list, (a, b) -> a.price - b.price);
        var r = JavaBaseApplicationTests.max(jonathanList, new myCompartor<apple>() {
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

    @Test
    void test_mycmp2() {
        var i = Integer.valueOf(2);
        var j = Integer.valueOf(3);
        testcm2(new myCompartor2<>(i, j));
    }


    interface myCmp<T> {
        int cmpTo(T h1, T h2);

        default void nothing(T t) {

        }
    }

    class Box<T extends Comparable<? super T>> {
        private T t;

        public Box(T t) {
            this.t = t;
        }

        public <U extends T> void hi(U t) {
            System.out.println(t);
        }

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }

    }

    class A {
    }

    class B extends A implements Comparable<A> {
        @Override
        public int compareTo(A o) {
            return 0;
        }
    }

    class C extends B {
    }

    class D<T> extends C {
        T t;

        D(T t) {
            this.t = t;
        }

        public T getvalue() {
            return t;
        }
    }

    @Test
    void justsoso() {
        List<? super String> list = new ArrayList<>();
        List<?> list1 = list;
        Object o = list;
        if (o instanceof List<?>) {

        }
    }


}


