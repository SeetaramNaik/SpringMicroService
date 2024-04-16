package com.productservice.orderservice.service;

import com.productservice.orderservice.dto.OrderRequest;
import org.springframework.stereotype.Service;

public interface OrderService {
    void placeOrder(OrderRequest orderRequest);
}
