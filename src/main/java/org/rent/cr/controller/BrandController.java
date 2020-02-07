package org.rent.cr.controller;

import org.rent.cr.dto.car.BrandDto;
import org.rent.cr.entity.car.Brand;
import org.rent.cr.entity.car.Model;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("brands")
public class BrandController extends CrudController<Brand, BrandService> {
    private BrandService brandService;

    @Autowired
    public BrandController(BrandService service) {
        super(service, "Brand");
        brandService = service;
    }

//    @Override
//    public Page<Brand> getPage(@RequestParam(name = "page", defaultValue = "1") Integer page, @RequestParam(name = "per_page", defaultValue = "20") Integer size, @RequestParam(name = "sort", defaultValue = "") String field, @RequestParam(name = "filter", defaultValue = "") String filter) {
//        Page result = super.getPage(page, size, field, filter);
//        MappingJacksonValue jacksonValue = new MappingJacksonValue(result);
//        return result;
//    }

    @Override
    @Secured("ROLE_ADMIN")
    public Object findById(@PathVariable("id") int id) throws NoEntityException {
        return super.findById(id);
    }

    @GetMapping("{id}/models")
    public Object findByIdModels(@PathVariable("id") int id) throws NoEntityException {
        return ((Brand) super.findById(id)).getModels();
    }
}
