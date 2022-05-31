package com.example.javadesignpattern.adapterPattern.service;

import lombok.extern.slf4j.Slf4j;

/**
 * Author saino
 * LastModify 9:59
 */
@Slf4j
public class POPOrderService {
    public boolean isFirstOrder(String userId) {
        log.info("POPOrderService isFirstOrder userId:{}", userId);
        return true;
    }
}
