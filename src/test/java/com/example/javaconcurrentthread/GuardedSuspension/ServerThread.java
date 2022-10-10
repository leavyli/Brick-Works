package com.example.javaconcurrentthread.GuardedSuspension;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * Author saino
 * Create 2022/10/10 9:13
 */
@Slf4j
public class ServerThread extends Thread {
    private final Random random;
    private final RequestQueue requestQueue;

    public ServerThread(RequestQueue requestQueue, String name, Long seed) {
        super(name);
        this.random = new Random(seed);
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            // 从队列获取请求
            Request request = requestQueue.getRequest();
            log.info("ServerThread name: {}, Request: {}", Thread.currentThread().getName(), request);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                log.info("ServerThread InterruptedExeception: {}", e);
            }
        }
    }
}
