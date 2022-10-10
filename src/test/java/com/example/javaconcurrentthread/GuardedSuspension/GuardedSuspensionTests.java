package com.example.javaconcurrentthread.GuardedSuspension;

import org.junit.jupiter.api.Test;

/**
 * Author saino
 * Create 2022/10/10 9:00
 */
public class GuardedSuspensionTests {
    @Test
    public void test() throws InterruptedException {
        RequestQueue requestQueue = new RequestQueue();
        ClientThread client = new ClientThread(requestQueue, "Alice", 31415926L);
        client.start();

        ServerThread server = new ServerThread(requestQueue, "Bobby", 61415926L);
        server.start();
        while(client.isAlive() || server.isAlive()) {
            Thread.sleep(5000);
        }
    }
}
