package com.example.javabase.service.impl;

import com.example.javabase.service.TransferService;
import lombok.extern.slf4j.Slf4j;

/**
 * Author saino
 * LastModify 4:58
 */
@Slf4j
public class TransferServiceImpl implements TransferService {
    public void initFirst(){
        log.info("initFirst");
    }
    public void initSecond(){
        log.info("initSecond");
    }
    public TransferServiceImpl() {
        log.info("TransferServiceImpl");
    }
}
