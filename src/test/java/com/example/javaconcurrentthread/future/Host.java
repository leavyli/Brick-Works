package com.example.javaconcurrentthread.future;

import lombok.extern.slf4j.Slf4j;

/**
 * Author saino
 * Create 2022/10/11 10:13
 */
@Slf4j
public class Host {
    public Data request(final int count, final char c) {
        log.info("      request: count:{}, c:{} BEGIN", count, c);


        final FutureData future = new FutureData();
        new Thread(() -> {
            RealData realData = new RealData(count, c);
            future.setRealData(realData);
        }).start();

        log.info("      request: count:{}, c:{} END", count, c);
        return future;
    }
}
