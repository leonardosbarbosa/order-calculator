package com.leonardosbarbosa.ordercalculator.services;

import com.leonardosbarbosa.ordercalculator.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final ShippingService shippingService;

    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public double total(Order order) {
        var discountValue = order.basic() * (order.discount() / 100);
        return order.basic() + shippingService.shipment(order) - discountValue;
    }
}
