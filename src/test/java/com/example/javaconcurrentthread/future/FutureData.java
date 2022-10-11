package com.example.javaconcurrentthread.future;

import lombok.extern.slf4j.Slf4j;

/**
 * Author saino
 * Create 2022/10/11 10:13
 */
@Slf4j
public class FutureData implements Data{
    private RealData realData = null;
    private boolean ready = false;

    public synchronized void setRealData(RealData realData) {
        if (ready) {
            return;
        }
        this.realData = realData;
        this.ready = true;
        notifyAll();
    }

    @Override
    public synchronized String getContent() {
        if (!ready) {
            try {
                wait();
            } catch (InterruptedException e) {
                log.info("FutureData InterruptedExection: {}", e);
            }
        }

        return realData.getContent();
    }
}
