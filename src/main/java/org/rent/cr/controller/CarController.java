package org.rent.cr.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.rent.cr.dto.view.View;
import org.rent.cr.entity.Order;
import org.rent.cr.entity.Reservation;
import org.rent.cr.entity.car.Car;
import org.rent.cr.entity.car.Image;
import org.rent.cr.entity.car.Option;
import org.rent.cr.entity.car.Price;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cars")
public class CarController extends CrudController<Car, CarService> {
    private CarService carService;

    @Autowired
    public CarController(CarService service) {
        super(service, "Car");
        carService = service;
    }

    @Override
    public Car findById(@PathVariable("id") int id) throws NoEntityException {
        return super.findById(id);
    }

    @GetMapping("prices")
    public List<Price> findByIdPrices(@PathVariable("id") int id) throws NoEntityException {
        return super.findById(id).getPrices();
    }

    @GetMapping("orders")
    public List<Order> findByIdOrders(@PathVariable("id") int id) throws NoEntityException {
        return super.findById(id).getOrders();
    }

    @GetMapping("reservations")
    public List<Reservation> findByIdReservations(@PathVariable("id") int id) throws NoEntityException {
        return super.findById(id).getReservations();
    }

    @GetMapping("options")
    public List<Option> findByIdOptions(@PathVariable("id") int id) throws NoEntityException {
        return super.findById(id).getOptions();
    }

    @GetMapping("images")
    public List<Image> findByIdImages(@PathVariable("id") int id) throws NoEntityException {
        return super.findById(id).getImages();
    }
}
