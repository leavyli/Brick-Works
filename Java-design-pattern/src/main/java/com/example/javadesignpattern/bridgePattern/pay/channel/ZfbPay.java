package com.example.javadesignpattern.bridgePattern.pay.channel;

import com.example.javadesignpattern.bridgePattern.pay.mode.IPayMode;
import lombok.extern.slf4j.Slf4j;

/**
 * Author saino
 * LastModify 10:22
 */
@Slf4j
public class ZfbPay extends Pay {
    public ZfbPay(IPayMode payMode) {
        super(payMode);
    }
    @Override
    public String transfer(String uId, String tradeId, double amount) {
        log.info("模拟⽀支付宝渠道⽀支付划账开始。uId：{} tradeId：{} amount： {}", uId, tradeId, amount);
        boolean security = payMode.security(uId);
        log.info("模拟⽀支付宝渠道⽀支付⻛风控校验。uId：{} tradeId：{} security： {}", uId, tradeId, security);
        if (!security) {
            log.info("模拟⽀支付宝渠道⽀支付划账拦截。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
            return "0001";
        }
        log.info("模拟⽀支付宝渠道⽀支付划账成功。uId：{} tradeId：{} amount： {}", uId, tradeId, amount);
        return "0000";
    }
}
