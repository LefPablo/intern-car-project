package org.rent.cr.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.rent.cr.dto.view.View;
import org.rent.cr.entity.Reservation;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("reservations")
public class ReservationController extends CrudController<Reservation, ReservationService> {
    private ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService service) {
        super(service, "Reservation");
        reservationService = service;
    }

    @JsonView(View.PrivateReserv.class)
    @Override
    public Reservation findById(@PathVariable("id") int id) throws NoEntityException {
        return super.findById(id);
    }

    @PostMapping("{id}/order")
    public void makeOrder(@PathVariable("id") Reservation reservation) {
        reservationService.makeOrder(reservation);
    }
}
