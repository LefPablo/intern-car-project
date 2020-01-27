package org.rent.cr.controller;

import org.rent.cr.entity.car.Option;
import org.rent.cr.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("options")
public class OptionController extends CrudController<Option, OptionService> {
    private OptionService optionService;

    @Autowired
    public OptionController(OptionService service) {
        super(service, "Option");
        optionService = service;
    }

}