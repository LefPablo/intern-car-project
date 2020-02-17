package org.rent.cr.controller;

import lombok.extern.slf4j.Slf4j;
import org.rent.cr.entity.Order;
import org.rent.cr.entity.Reservation;
import org.rent.cr.exception.*;
import org.rent.cr.service.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("reservations")
public class ReservationController extends CrudController<Reservation, ReservationService> {

    @Autowired
    public ReservationController(ReservationService service) {
        super(service);
    }

    @Override
    public Object findById(@PathVariable("id") int id) throws NoEntityException {
        return super.findById(id);
    }

    @PostMapping("{id}/employee")
    public void setEmployeeFromAuthentication(@PathVariable("id") Reservation reservation) throws NotUpdatedException {
        service.setEmployeeFromAuthentication(reservation);
    }

    @PostMapping("{id}/order")
    public Order makeOrder(@PathVariable("id") Reservation reservation) throws PeriodNotValidException, NotSavedException {
        Order order = service.makeOrder(reservation);
        log.info("Order by reservation is created. {id=" + order.getId() + "}");
        return order;
    }
}












