package org.rent.cr.controller;

import org.rent.cr.entity.car.Price;
import org.rent.cr.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("prices")
public class PriceController extends CrudController<Price, PriceService> {
    PriceService priceService;

    @Autowired
    public PriceController(PriceService service) {
        super(service, "Price");
        priceService = service;
    }
}
