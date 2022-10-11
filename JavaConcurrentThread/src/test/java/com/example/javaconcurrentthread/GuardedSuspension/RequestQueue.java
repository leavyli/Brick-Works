package com.example.javaconcurrentthread.GuardedSuspension;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Author saino
 * Create 2022/10/10 9:02
 */
@Slf4j
public class RequestQueue {
    private final BlockingQueue<Request> queue = new LinkedBlockingQueue<>();

    public Request getRequest() {
        Request request = null;

        try {
            request = queue.take();
        } catch (InterruptedException e) {
            log.info("RequestQueue InterruptedException: {}", e);
        }

        return request;
    }

    public void putRequest(Request request) {
        try {
            queue.put(request);
        } catch (InterruptedException e) {
            log.info("RequestQueue InterruptedException: {}", e);
        }
    }
}
