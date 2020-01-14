package org.rent.cr.service.impl;

import org.rent.cr.entity.Order;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.service.EntityService;

import java.util.List;

public class OrderServiceImpl implements EntityService<Order> {
    @Override
    public Order findById(int id) throws NoEntityException {
        return null;
    }

    @Override
    public Order save(Order entity) {
        return null;
    }

    @Override
    public Order update(Order entity) {
        return null;
    }

    @Override
    public void delete(Order entity) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Order> findAll() {
        return null;
    }
}
