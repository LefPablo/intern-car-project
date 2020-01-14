package org.rent.cr.service.impl;

import org.rent.cr.entity.Fine;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.service.EntityService;

import java.util.List;

public class FineServiceImpl implements EntityService<Fine> {
    @Override
    public Fine findById(int id) throws NoEntityException {
        return null;
    }

    @Override
    public Fine save(Fine entity) {
        return null;
    }

    @Override
    public Fine update(Fine entity) {
        return null;
    }

    @Override
    public void delete(Fine entity) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Fine> findAll() {
        return null;
    }
}
