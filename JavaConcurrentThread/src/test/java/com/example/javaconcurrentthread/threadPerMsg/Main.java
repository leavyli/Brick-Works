package com.example.javaconcurrentthread.threadPerMsg;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Author saino
 * Create 2022/10/10 13:50
 */
public class Main {
    @Test
    public void start() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5, 50,
                2, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1000),
                new ThreadFactoryBuilder().setNameFormat("host-threadpool-%d").build()
        );


        Host host = new Host(threadPoolExecutor);
//        Host host = new Host((ThreadPoolExecutor) Executors.newCachedThreadPool());
        host.request(10, 'A');
        host.request(20, 'B');
        host.request(30, 'C');

        Thread.sleep(20000);
    }
}
