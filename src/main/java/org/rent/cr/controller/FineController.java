package org.rent.cr.controller;

import org.rent.cr.entity.Fine;
import org.rent.cr.service.FineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("fines")
public class FineController extends CrudController<Fine, org.rent.cr.service.FineService> {

    @Autowired
    public FineController(FineService service) {
        super(service);
    }
}