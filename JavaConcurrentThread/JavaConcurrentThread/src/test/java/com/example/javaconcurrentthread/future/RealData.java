package com.example.javaconcurrentthread.future;

import lombok.extern.slf4j.Slf4j;

/**
 * Author saino
 * Create 2022/10/11 10:33
 */
@Slf4j
public class RealData implements Data {
    private final String content;

    public RealData(int count, char c) {
        log.info("          ReadData count:{}, c:{} BEGIN", count, c);
        char[] buffer = new char[count];
        for (int i = 0; i < count; i++) {
            buffer[i] = c;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
        }
        log.info("          ReadData count:{}, c:{} END", count, c);
        this.content = new String(buffer);
    }

    @Override
    public String getContent() {
        return content;
    }
}
