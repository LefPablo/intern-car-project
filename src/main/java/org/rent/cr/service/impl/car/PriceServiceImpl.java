package org.rent.cr.service.impl.car;

import org.rent.cr.entity.car.Price;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.service.EntityService;

import java.util.List;

public class PriceServiceImpl implements EntityService<Price> {
    @Override
    public Price findById(int id) throws NoEntityException {
        return null;
    }

    @Override
    public Price save(Price entity) {
        return null;
    }

    @Override
    public Price update(Price entity) {
        return null;
    }

    @Override
    public void delete(Price entity) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Price> findAll() {
        return null;
    }
}
