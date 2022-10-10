package com.example.javaconcurrentthread.GuardedSuspension;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * Author saino
 * Create 2022/10/10 9:07
 */
@Slf4j
public class ClientThread extends Thread{
    private final RequestQueue requestQueue;
    private final Random random;

    public ClientThread(RequestQueue requestQueue, String name, long seed) {
        super(name);
        this.requestQueue = requestQueue;
        this.random =new Random(seed);
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Request request = new Request("No." + i);
            log.info("Client Thread name: {}, Request: {}", Thread.currentThread().getName(), request);

            // 把请求放入队列
            requestQueue.putRequest(request);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                log.info("ClientThread InterruptedExecption: {}", e);
            }
        }
    }
}
