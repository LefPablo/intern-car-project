package org.rent.cr.controller;

import org.rent.cr.entity.Period;
import org.rent.cr.service.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("period")
public class PeriodController extends CrudController<Period, PeriodService> {
    private PeriodService periodService;

    @Autowired
    public PeriodController(PeriodService service) {
        super(service, "Period");
        periodService = service;
    }
}
