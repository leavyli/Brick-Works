package com.example.javaconcurrentthread.threadPerMsg;

import lombok.extern.slf4j.Slf4j;

/**
 * Author saino
 * Create 2022/10/10 13:50
 */
@Slf4j
public class Helper {
    public void handler(int count, char c) {
        log.info("     handler(count: {}, c: {} BEGIN", count, c);
        for (int i = 0; i < count; i++) {
            slowly();
            log.info("c:" + c);
        }

        log.info("     handler(count: {}, c: {} END", count, c);
    }

    public void slowly() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
