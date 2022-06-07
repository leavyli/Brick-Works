package com.example.javadesignpattern.bridgePattern.pay.channel;

import com.example.javadesignpattern.bridgePattern.pay.mode.IPayMode;
import lombok.extern.slf4j.Slf4j;

/**
 * Author saino
 * LastModify 9:52
 */
@Slf4j
public abstract class Pay {
    protected IPayMode payMode;

    public Pay(IPayMode payMode) {
        this.payMode = payMode;
    }

    public abstract String transfer(String uId, String tradeId,double amount);

}
