package com.example.javaconcurrentthread.threadPerMsg;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Author saino
 * Create 2022/10/10 13:50
 */
@RequiredArgsConstructor
public class Host {
//    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
//            10, 50,
//            2, TimeUnit.SECONDS,
//            new ArrayBlockingQueue<>(1000),
//            new ThreadFactoryBuilder().setNameFormat("host-threadpool-%d").build()
//    );
    private final Helper helper = new Helper();
    private final ThreadPoolExecutor threadPoolExecutor;

    public void request(int count , char c) {
        threadPoolExecutor.execute(()-> helper.handler(count, c));
    }
}
