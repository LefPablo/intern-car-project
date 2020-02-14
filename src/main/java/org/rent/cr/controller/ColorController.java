package org.rent.cr.controller;

import org.rent.cr.entity.car.Color;
import org.rent.cr.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("colors")
public class ColorController extends CrudController<Color, ColorService> {

    @Autowired
    public ColorController(ColorService service) {
        super(service);
    }
}
