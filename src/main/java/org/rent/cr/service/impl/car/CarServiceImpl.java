package org.rent.cr.service.impl.car;

import org.rent.cr.entity.car.Car;
import org.rent.cr.dao.repo.car.CarRepository;
import org.rent.cr.service.CarService;
import org.rent.cr.service.impl.EntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CarServiceImpl extends EntityServiceImpl<Car, CarRepository> implements CarService {
    private CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        super(carRepository, "Car");
        this.carRepository = carRepository;
    }
}
