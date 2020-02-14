package org.rent.cr.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.rent.cr.dto.view.View;
import org.rent.cr.entity.Equipment;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("equipments")
public class EquipmentController extends CrudController<Equipment, EquipmentService> {

    @Autowired
    public EquipmentController(EquipmentService service) {
        super(service);
    }

    @Override
    public Object findById(@PathVariable("id") int id) throws NoEntityException {
        return super.findById(id);
    }
}
