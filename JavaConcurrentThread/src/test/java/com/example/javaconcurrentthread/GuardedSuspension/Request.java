package com.example.javaconcurrentthread.GuardedSuspension;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Author saino
 * Create 2022/10/10 9:01
 */
@Setter
@Getter
@RequiredArgsConstructor
public class Request {
    private final String name;

    public String toString() {
        return "Request(name=" + this.getName() + ")";
    }
}
