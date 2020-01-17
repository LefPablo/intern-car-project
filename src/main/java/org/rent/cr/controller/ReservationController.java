package org.rent.cr.controller;

import org.rent.cr.entity.Reservation;
import org.rent.cr.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("reservation")
public class ReservationController extends CrudController<Reservation, ReservationService> {
    private ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService service) {
        super(service, "Reservation");
        reservationService = service;
    }

    @PostMapping("order")
    public void makeOrder(@RequestBody Reservation reservation) {
        reservationService.makeOrder(reservation);
    }
}
