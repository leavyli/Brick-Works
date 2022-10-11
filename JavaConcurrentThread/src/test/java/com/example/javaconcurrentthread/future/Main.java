package com.example.javaconcurrentthread.future;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * Author saino
 * Create 2022/10/11 10:12
 */
@Slf4j
public class Main {
    @Test
    public void start() {
        Host host = new Host();
        var data1 = host.request(10, 'A');
        var data2 = host.request(20, 'B');
        var data3 = host.request(30, 'C');

        // 模拟做另外的工作
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        log.info("Main other Job Start");
        log.info("data1 = {}", data1.getContent());
        log.info("data2 = {}", data2.getContent());
        log.info("data3 = {}", data3.getContent());
        log.info("Main other Job End");

    }
}
