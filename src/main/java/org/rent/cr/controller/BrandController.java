package org.rent.cr.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.rent.cr.dto.view.View;
import org.rent.cr.entity.car.Brand;
import org.rent.cr.entity.car.Model;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Override
    public Brand findById(@PathVariable("id") int id) throws NoEntityException {
        return super.findById(id);
    }

    //    @GetMapping("{id}/models")
//    public List<Model> findByIdModels(@PathVariable("id") int id) throws NoEntityException {
//        return super.findById(id).getModels();
//    }
}
