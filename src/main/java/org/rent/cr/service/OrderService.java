package org.rent.cr.service;

import org.rent.cr.entity.Order;
import org.rent.cr.exception.NoEntityException;

public interface OrderService extends CrudService<Order> {
    boolean isLegalPeriod(Order order) throws NoEntityException;
    void setEmployeeFromAuthentication(Order order);
}
