package org.rent.cr.controller;

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

@RestController
@RequestMapping("reservations")
public class ReservationController extends CrudController<Reservation, ReservationService> {
    private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);

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
        return service.makeOrder(reservation);
    }
}












