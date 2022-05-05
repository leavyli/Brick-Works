package com.example.logrecord.logrecord.service;

import com.example.logrecord.logrecord.annotation.LogRecord;
import com.example.logrecord.logrecord.bo.updateDeliveryRequest;

/**
 * @author: saino
 * @Description:
 * @date:2022/5/5 9:20
 */
public class Address {
    @LogRecord(content = "修改了订单的配送地址：从“#oldAddress”, 修改到“#request.address”")
    public void modifyAddress(updateDeliveryRequest request, String oldAddress) {
        // 更新派送信息 电话，收件人、地址
        doUpdate(request);
    }

    public void doUpdate(updateDeliveryRequest request) {

    }
}
