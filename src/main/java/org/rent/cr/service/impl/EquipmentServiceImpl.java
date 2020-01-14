package org.rent.cr.service.impl;

import org.rent.cr.entity.Equipment;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.service.EntityService;

import java.util.List;

public class EquipmentServiceImpl implements EntityService<Equipment> {
    @Override
    public Equipment findById(int id) throws NoEntityException {
        return null;
    }

    @Override
    public Equipment save(Equipment entity) {
        return null;
    }

    @Override
    public Equipment update(Equipment entity) {
        return null;
    }

    @Override
    public void delete(Equipment entity) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Equipment> findAll() {
        return null;
    }
}
