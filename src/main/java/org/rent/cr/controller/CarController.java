package org.rent.cr.controller;

import org.rent.cr.entity.car.Car;
import org.rent.cr.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("car")
public class CarController extends CrudController<Car, CarService> {
    private CarService carService;

    @Autowired
    public CarController(CarService service) {
        super(service, "Car");
        carService = service;
    }
}
