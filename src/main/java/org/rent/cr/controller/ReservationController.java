package org.rent.cr.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.rent.cr.dto.view.View;
import org.rent.cr.entity.Order;
import org.rent.cr.entity.Reservation;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.exception.NotSavedException;
import org.rent.cr.exception.NotUpdatedException;
import org.rent.cr.exception.NotValidException;
import org.rent.cr.service.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;

@RestController
@RequestMapping("reservations")
public class ReservationController extends CrudController<Reservation, ReservationService> {
    private ReservationService reservationService;
    private ServletContext servletContext;

    private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);

    @Autowired
    public ReservationController(ReservationService service, ServletContext servletContext) {
        super(service, "Reservation");
        reservationService = service;
        this.servletContext = servletContext;
    }

    @JsonView(View.PrivateReserv.class)
    @Override
    public Reservation findById(@PathVariable("id") int id) throws NoEntityException {
        return super.findById(id);
    }

    @PostMapping("{id}/employee")
    public void setEmployeeFromAuthentication(@PathVariable("id") Reservation reservation) throws NotUpdatedException {
        reservationService.setEmployeeFromAuthentication(reservation);
    }

    @PostMapping("{id}/order")
    public Order makeOrder(@PathVariable("id") Reservation reservation) throws NotValidException, NotSavedException {
        return reservationService.makeOrder(reservation);
    }
}












