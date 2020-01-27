package org.rent.cr.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.rent.cr.dto.view.View;
import org.rent.cr.entity.Order;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
public class OrderController extends CrudController<Order, OrderService> {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService service) {
        super(service, "Order");
        orderService = service;
    }

    @JsonView(View.PrivateOrder.class)
    @Override
    public Order findById(@PathVariable("id") int id) throws NoEntityException {
        return super.findById(id);
    }
}
