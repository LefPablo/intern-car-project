package org.rent.cr.controller;

import org.rent.cr.entity.car.Model;
import org.rent.cr.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("model")
public class ModelController extends CrudController<Model, ModelService> {
    ModelService ModelService;

    @Autowired
    public ModelController(ModelService service) {
        super(service, "Model");
        ModelService = service;
    }
}
