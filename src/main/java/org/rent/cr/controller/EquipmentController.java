package org.rent.cr.controller;

import org.rent.cr.entity.Equipment;
import org.rent.cr.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("equipment")
public class EquipmentController extends CrudController<Equipment, EquipmentService> {
    private EquipmentService equipmentService;

    @Autowired
    public EquipmentController(EquipmentService service) {
        super(service, "Equipment");
        equipmentService = service;
    }
}
