package com.example.javadesignpattern.bridgePattern.pay.mode;

import lombok.extern.slf4j.Slf4j;

/**
 * Author saino
 * LastModify 10:23
 */
@Slf4j
public class PayFingerprintMode implements IPayMode{

    @Override
    public boolean security(String uId) {
        log.info("指纹支付");
        return true;
    }
}
