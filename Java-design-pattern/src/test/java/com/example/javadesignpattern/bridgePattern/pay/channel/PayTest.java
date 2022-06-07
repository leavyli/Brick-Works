package com.example.javadesignpattern.bridgePattern.pay.channel;

import com.example.javadesignpattern.bridgePattern.pay.mode.PayFaceMode;
import com.example.javadesignpattern.bridgePattern.pay.mode.PayFingerprintMode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class PayTest {
    @Test
    public void test_pay() {
        Pay wxPay = new WxPay(new PayFaceMode());
        wxPay.transfer("123", "456", 100);

        Pay zfbPay = new ZfbPay(new PayFingerprintMode());
        zfbPay.transfer("123", "456", 100);
    }

}