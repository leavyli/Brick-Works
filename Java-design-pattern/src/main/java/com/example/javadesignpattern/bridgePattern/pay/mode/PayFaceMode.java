package com.example.javadesignpattern.bridgePattern.pay.mode;

import lombok.extern.slf4j.Slf4j;

/**
 * Author saino
 * LastModify 10:23
 */
@Slf4j
public class PayFaceMode implements IPayMode{
    @Override
    public boolean security(String uId) {
        log.info("人脸支付");
        return true;
    }
}
