package com.example.javabase.functionHello;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author saino
 * LastModify 16:20
 */
@Slf4j
public class FunctionHello {
    public static String processFile(BufferReaderProcess p, BufferedReader bufferedReader) throws IOException {
        return p.process(bufferedReader);
    }

    @Test
    void testProcessFile() throws IOException {
        var buffReader = new BufferedReader(new FileReader("e:/tt/hello.txt"));
        String oneLine = processFile((BufferedReader br) -> br.readLine(), buffReader);
        log.info("oneLine:{} ", oneLine);
        String twoLine = processFile((BufferedReader br) -> br.readLine() + br.readLine(), buffReader);
        log.info("twoLine:{} ", twoLine);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        var result = list.stream().filter((el) -> predicate.test(el)).collect(Collectors.toList());
        return result;
    }

    @Test
    void testFilter() {
        var list = new ArrayList<Integer>(List.of(1, 2, 3));
        var result = filter(list, (el) -> el > 1);
        log.info("result:{}", result);
    }

    public static <T> void forEach(List<? extends T> list, Consumer<? super T> consumer) {
//        list.stream().forEach((el) -> consumer.accept(el));
        for (T t : list) {
            consumer.accept(t);
        }
    }

    @Test
    void testForEach() {
        var list = new ArrayList<>(List.of("Hi", "who", "you"));
//        var list = new ArrayList<Integer>(List.of(1, 2, 3));
//        var consumer = (el) -> log.info("el:{} {}", el, el.getClass());
        forEach(list, (el) -> log.info("el:{} {}", el, el.getClass()));
    }

    @Test
    void testForEach2() {
        List<A> list = new ArrayList<>();
        list.add(new A());
        list.add(new B());
        //都是对应的Class，即使转换了，getClass获取的仍然是底层的真正对应的Class
        forEach(list, (el) -> log.info("el:{} {}", el, el.getClass()));

        List<B> list2 = new ArrayList<>();
        list2.add(new B());
        list2.add(new B());
        forEach(list2, (A el) -> log.info("el:{} {}", el, el.getClass()));

        var b = new B();
        log.info("b:{}", ((A) b).getClass());
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(function.apply(t));
        }
        return result;
    }

    @Test
    void testMap() {
        var l = map(
                Arrays.asList("lambdas", "in", "action"),
                (String s) -> s.length()
        );

        log.info("l:{}", l);
    }

    @Test
    void testAppleSort() {
        List<Apple> appleList = Arrays.asList(new Apple(3), new Apple(12), new Apple(2));
        log.info("before sort:{}", appleList);
        appleList.sort(Comparator.comparing(Apple::getWeight).reversed());
        log.info("after sort:{}", appleList);
    }

    @Test
    void testGetClass() {
        var a = new A();
        var b = new B();
        Class<? extends A> aClass = a.getClass();
        Class<? extends A> bClass = b.getClass();
    }
}
