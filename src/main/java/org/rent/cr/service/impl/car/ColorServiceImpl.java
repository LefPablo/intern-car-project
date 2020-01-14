package org.rent.cr.service.impl.car;

import org.rent.cr.entity.car.Color;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.service.EntityService;

import java.util.List;

public class ColorServiceImpl implements EntityService<Color> {
    @Override
    public Color findById(int id) throws NoEntityException {
        return null;
    }

    @Override
    public Color save(Color entity) {
        return null;
    }

    @Override
    public Color update(Color entity) {
        return null;
    }

    @Override
    public void delete(Color entity) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Color> findAll() {
        return null;
    }
}
