package org.rent.cr.controller;

import org.rent.cr.entity.Order;
import org.rent.cr.exception.IllegalActionException;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.exception.NotSavedException;
import org.rent.cr.exception.NotUpdatedException;
import org.rent.cr.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("orders")
public class OrderController extends CrudController<Order, OrderService> {

    @Autowired
    public OrderController(OrderService service) {
        super(service);
    }

    @Override
    public Object save(@RequestBody Order order) throws NotSavedException, IllegalActionException, NoEntityException {
        if (!service.isLegalPeriod(order)) {
            throw new IllegalActionException("Car is unavailable for this period");
        }
        return super.save(order);
    }

    @PostMapping("{id}/employee")
    public void setEmployeeFromAuthentication(@PathVariable("id") Order order) {
        service.setEmployeeFromAuthentication(order);
    }
}
