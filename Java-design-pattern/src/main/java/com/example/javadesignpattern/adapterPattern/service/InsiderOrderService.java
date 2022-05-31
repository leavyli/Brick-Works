package com.example.javadesignpattern.adapterPattern.service;

import com.example.javadesignpattern.adapterPattern.service.adapter.OrderAdapterService;
import org.springframework.stereotype.Service;

/**
 * Author saino
 * LastModify 19:30
 */
@Service
public class InsiderOrderService implements OrderAdapterService {
    private final OrderService orderService;

    public InsiderOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public boolean isFirst(String uId) {
        return orderService.queryUserOrderCount(uId) <= 1;
    }
}
