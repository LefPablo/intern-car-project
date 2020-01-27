package org.rent.cr.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.rent.cr.dto.view.View;
import org.rent.cr.entity.Period;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.service.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("periods")
public class PeriodController extends CrudController<Period, PeriodService> {
    private PeriodService periodService;

    @Autowired
    public PeriodController(PeriodService service) {
        super(service, "Period");
        periodService = service;
    }

    @JsonView(View.PrivatePeriod.class)
    @Override
    public Period findById(@PathVariable("id") int id) throws NoEntityException {
        return super.findById(id);
    }
}
