package org.rent.cr.service.impl;

import org.rent.cr.entity.Equipment;
import org.rent.cr.repo.EquipmentRepository;
import org.rent.cr.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EquipmentServiceImpl extends EntityServiceImpl<Equipment, EquipmentRepository> implements EquipmentService {
    private EquipmentRepository equipmentRepository;

    @Autowired
    public EquipmentServiceImpl(EquipmentRepository equipmentRepository) {
        super(equipmentRepository, "Equipment");
        this.equipmentRepository = equipmentRepository;
    }
}
