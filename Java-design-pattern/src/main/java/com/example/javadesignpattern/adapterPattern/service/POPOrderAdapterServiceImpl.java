package com.example.javadesignpattern.adapterPattern.service;

import com.example.javadesignpattern.adapterPattern.service.adapter.OrderAdapterService;
import org.springframework.stereotype.Service;

/**
 * Author saino
 * LastModify 19:32
 */
@Service
public class POPOrderAdapterServiceImpl implements OrderAdapterService {
    private final POPOrderService popOrderService;

    public POPOrderAdapterServiceImpl(POPOrderService popOrderService) {
        this.popOrderService = popOrderService;
    }

    @Override
    public boolean isFirst(String uId) {
        return popOrderService.isFirstOrder(uId);
    }
}
