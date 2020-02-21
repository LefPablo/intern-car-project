package org.rent.cr.controller;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.extern.slf4j.Slf4j;
import org.rent.cr.dto.view.View;
import org.rent.cr.entity.Order;
import org.rent.cr.entity.Reservation;
import org.rent.cr.exception.*;
import org.rent.cr.service.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("reservations")
public class ReservationController {

    @Autowired
    ReservationService service;

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

    @JsonView(View.Public.class)
    @GetMapping("all")
    public Object findAll() {
        return service.findAll();
    }

    @JsonView(View.Public.class)
    @GetMapping
    public Object getPage(@RequestParam(name = "page", defaultValue = "1") Integer page, @RequestParam(name = "per_page", defaultValue = "20") Integer size, @RequestParam(name = "sort", required = false) String field, @RequestParam(name = "filter", required = false) String filter) {
        String order = null;
        if (field != null) {
            String[] params = field.split("\\|");
            if (params.length == 2) {
                order = params[1];
                field = params[0];
            }
        }
        Page<Reservation> result = service.getPage(page, size, field, order, filter);
        return result;
    }

    @JsonView(View.Private.class)
    @GetMapping("{id}")
    public Object findById(@PathVariable("id") int id) throws NoEntityException {
        Reservation entity =  service.findById(id);
        return entity;
    }

    @JsonView(View.Private.class)
    @PostMapping
    public Object save(@RequestBody Reservation entity) throws NotSavedException, IllegalActionException, NoEntityException {
        entity =  service.save(entity);
        log.info("Reservation" + " added {id=" + entity.getId() + "}");
        return entity;
    }

    @JsonView(View.Private.class)
    @PutMapping("{id}")
    public Object update(@PathVariable("id") Reservation entityFromDb, @RequestBody Reservation entity) {
        entity =  service.update(entityFromDb, entity);
        log.info("Reservation" + " updated {id=" + entity.getId() + "}");
        return entity;
    }

    @DeleteMapping("deleteAll")
    public Object deleteAll() {
        long count = service.deleteAll();
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("message", "Reservation" + " all records deleted {count=" + count + "}");
        log.info("Reservation" + " all records deleted {count=" + count + "}");
        return responseMap;
    }

    @DeleteMapping("{id}")
    public Object delete(@PathVariable("id") Reservation entity) throws NoEntityException {
        service.delete(entity);
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("message", "Reservation" + " was deleted {id=" + entity.getId() + "}");
        log.info("Reservation" + " deleted");
        return responseMap;
    }
}












