package org.rent.cr.service.impl;

import org.rent.cr.entity.Characteristic;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.service.EntityService;

import java.util.List;

public class CharacteristicServiceImpl implements EntityService<Characteristic> {
    @Override
    public Characteristic findById(int id) throws NoEntityException {
        return null;
    }

    @Override
    public Characteristic save(Characteristic entity) {
        return null;
    }

    @Override
    public Characteristic update(Characteristic entity) {
        return null;
    }

    @Override
    public void delete(Characteristic entity) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Characteristic> findAll() {
        return null;
    }
}
