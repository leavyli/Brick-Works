package com.example.javadesignpattern.adapterPattern.service;

import lombok.extern.slf4j.Slf4j;

/**
 * Author saino
 * LastModify 9:54
 */
@Slf4j
public class OrderService {

    public long queryUserOrderCount(String userId) {
        log.info("query user order count");
        return 10L;
    }
}
