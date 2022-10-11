package com.example.javaconcurrentthread;

import com.google.common.util.concurrent.Striped;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Author saino
 * Create 2022/9/30 21:25
 */
@Slf4j
public class GuavaStripTests {
    private void test(int strips, int tasks) {
        Striped<Lock> stripedLocks = Striped.lock(strips);
        Set<Lock> used = IntStream.rangeClosed(1, tasks).boxed().map(v -> stripedLocks.get(v + "")).collect(Collectors.toSet());
        log.info("total locks:{}, tasks:{},  used locks:{}", strips, tasks, used.size());
    }

    @Test
    void testStrips() {
        test(20, 20);
        test(20, 40);
        test(20, 60);
        test(20, 80);

    }
}