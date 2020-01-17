package org.rent.cr.controller;

import org.rent.cr.entity.car.Brand;
import org.rent.cr.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("brand")
public class BrandController extends CrudController<Brand, BrandService> {
    private BrandService brandService;

    @Autowired
    public BrandController(BrandService service) {
        super(service, "Brand");
        brandService = service;
    }
}
