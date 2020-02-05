package org.rent.cr.service.impl;

import org.rent.cr.entity.Order;
import org.rent.cr.dao.repo.OrderRepository;
import org.rent.cr.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceImpl extends EntityServiceImpl<Order, OrderRepository> implements OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        super(orderRepository, "Order");
        this.orderRepository = orderRepository;
    }
}
