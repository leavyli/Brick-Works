package com.example.javabase.jdkProxy;

/**
 * Author saino
 * LastModify 11:44
 */
public class DefaultEchoService implements EchoService {
    @Override
    public String echo(String msg) {
        return "Default echo:" + msg;
    }
}
