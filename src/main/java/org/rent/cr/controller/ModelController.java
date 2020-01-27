package org.rent.cr.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.rent.cr.dto.view.View;
import org.rent.cr.entity.car.Model;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("models")
public class ModelController extends CrudController<Model, ModelService> {
    ModelService ModelService;

    @Autowired
    public ModelController(ModelService service) {
        super(service, "Model");
        ModelService = service;
    }

    @JsonView(View.PrivatePeriod.class)
    @Override
    public Model findById(@PathVariable("id") int id) throws NoEntityException {
        return super.findById(id);
    }
}
