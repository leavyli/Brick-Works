package com.example.learnkafka.controllers;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Author saino
 * LastModify 20:11
 */
public class CountingProducerInterceptor implements ProducerInterceptor {
    static AtomicLong numSent = new AtomicLong(0);
    static AtomicLong numAcked = new AtomicLong(0);
    ScheduledExecutorService executorService =
            Executors.newSingleThreadScheduledExecutor();

    public static void run() {
        System.out.println(numSent.getAndSet(0));
        System.out.println(numAcked.getAndSet(0));
    }

    public void configure(Map<String, ?> map) {
        Long windowSize = Long.valueOf(
                (String) map.get("counting.interceptor.window.size.ms"));
        executorService.scheduleAtFixedRate(CountingProducerInterceptor::run,
                windowSize, windowSize, TimeUnit.MILLISECONDS);
    }

    public ProducerRecord onSend(ProducerRecord producerRecord) {
        numSent.incrementAndGet();
        return producerRecord;
    }

    public void onAcknowledgement(RecordMetadata recordMetadata, Exception e) {
        numAcked.incrementAndGet();
    }

    public void close() {
        executorService.shutdownNow();
    }
}