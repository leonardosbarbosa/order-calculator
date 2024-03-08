package com.leonardosbarbosa.ordercalculator.services;

import com.leonardosbarbosa.ordercalculator.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public double shipment(Order order) {
        double shipmentValue = 0;
        if (order.basic() < 100.0) {
            shipmentValue = 20.0;
        } else if (order.basic() >= 100.0 && order.basic() <= 200.0) {
            shipmentValue = 12.0;
        }
        return shipmentValue;
    }
}
