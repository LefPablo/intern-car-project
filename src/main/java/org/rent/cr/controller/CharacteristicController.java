package org.rent.cr.controller;

import org.rent.cr.entity.Characteristic;
import org.rent.cr.service.CharacteristicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("characteristic")
public class CharacteristicController extends CrudController<Characteristic, CharacteristicService> {
    CharacteristicService CharacteristicService;

    @Autowired
    public CharacteristicController(CharacteristicService service) {
        super(service, "Characteristic");
        CharacteristicService = service;
    }
}
