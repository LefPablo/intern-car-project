package org.rent.cr.service.impl;

import org.rent.cr.entity.Period;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.service.EntityService;

import java.util.List;

public class PeriodServiceImpl implements EntityService<Period> {
    @Override
    public Period findById(int id) throws NoEntityException {
        return null;
    }

    @Override
    public Period save(Period entity) {
        return null;
    }

    @Override
    public Period update(Period entity) {
        return null;
    }

    @Override
    public void delete(Period entity) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Period> findAll() {
        return null;
    }
}
