package com.example.javabase.functionHello;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Author saino
 * LastModify 16:23
 */
@FunctionalInterface
public interface BufferReaderProcess<T extends BufferedReader> {
    String process(T b) throws IOException;
}
