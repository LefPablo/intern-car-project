package org.rent.cr.controller;

import org.rent.cr.entity.Order;
import org.rent.cr.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController extends CrudController<Order, OrderService> {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService service) {
        super(service, "Order");
        orderService = service;
    }
}
