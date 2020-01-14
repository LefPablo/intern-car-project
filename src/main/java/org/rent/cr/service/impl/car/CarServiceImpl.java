package org.rent.cr.service.impl.car;

import org.rent.cr.entity.car.Car;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.service.EntityService;

import java.util.List;

public class CarServiceImpl implements EntityService<Car> {
    @Override
    public Car findById(int id) throws NoEntityException {
        return null;
    }

    @Override
    public Car save(Car entity) {
        return null;
    }

    @Override
    public Car update(Car entity) {
        return null;
    }

    @Override
    public void delete(Car entity) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Car> findAll() {
        return null;
    }
}
