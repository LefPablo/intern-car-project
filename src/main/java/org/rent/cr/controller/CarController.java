package org.rent.cr.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.rent.cr.dto.car.CarDto;
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
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("{id}/prices")
    public List<Price> findByIdPrices(@PathVariable("id") int id) throws NoEntityException {
        return ((Car) super.findById(id)).getPrices();
    }

    @GetMapping("{id}/orders")
    public List<Order> findByIdOrders(@PathVariable("id") int id) throws NoEntityException {
        return ((Car) super.findById(id)).getOrders();
    }

    @GetMapping("reservations")
    public List<Reservation> findByIdReservations(@PathVariable("id") int id) throws NoEntityException {
        return ((Car) super.findById(id)).getReservations();
    }

    @GetMapping("{id}/options")
    public List<Option> findByIdOptions(@PathVariable("id") int id) throws NoEntityException {
        return ((Car) super.findById(id)).getOptions();
    }

    @GetMapping("{id}/images")
    public List<Image> findByIdImages(@PathVariable("id") int id) throws NoEntityException {
        return ((Car) super.findById(id)).getImages();
    }
}
