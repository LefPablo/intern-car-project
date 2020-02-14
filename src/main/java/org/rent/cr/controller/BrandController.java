package org.rent.cr.controller;

import org.rent.cr.entity.car.Brand;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("brands")
public class BrandController extends CrudController<Brand, BrandService> {

    @Autowired
    public BrandController(BrandService service) {
        super(service);
    }

    @Override
    @Secured("ROLE_ADMIN")
    public Object findById(@PathVariable("id") int id) throws NoEntityException {
        return super.findById(id);
    }

    @GetMapping("{id}/models")
    public Object getModels(@PathVariable("id") int id) throws NoEntityException {
        return ((Brand) super.findById(id)).getModels();
    }
}
