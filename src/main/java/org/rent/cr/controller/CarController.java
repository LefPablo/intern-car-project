package org.rent.cr.controller;

import org.rent.cr.entity.Order;
import org.rent.cr.entity.Reservation;
import org.rent.cr.entity.car.Car;
import org.rent.cr.entity.car.Image;
import org.rent.cr.entity.car.Option;
import org.rent.cr.entity.car.Price;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("cars")
public class CarController extends CrudController<Car, CarService> {

    @Autowired
    public CarController(CarService service) {
        super(service);
    }

    @GetMapping("{id}/prices")
    public List<Price> findByIdPrices(@PathVariable("id") int id) throws NoEntityException {
        return ((Car) super.findById(id)).getPrices();
    }

    @GetMapping("{id}/orders")
    public List<Order> findByIdOrders(@PathVariable("id") int id) throws NoEntityException {
        return ((Car) super.findById(id)).getOrders();
    }


    @GetMapping("{id}/closestOrder")
    public Order findByIdClosestOrder(@PathVariable("id") int id, @RequestParam(name = "dateTime", required = false) String dateTime, @RequestParam(name = "isCross", defaultValue = "true",required = false) boolean isCrossDateTime) throws NoEntityException {
        LocalDateTime time;
        if (dateTime == null) {
            time = LocalDateTime.now();
        } else {
            time = LocalDateTime.parse(dateTime);
        }
        return service.getClosestOrder(service.findById(id), time, isCrossDateTime);
    }

    @GetMapping("period")
    public List<Car> findCarsForPeriod(@RequestParam(name = "startDate", required = false) String startDate, @RequestParam(name = "endDate", required = false) String endDate) {
        LocalDateTime start;
        LocalDateTime end;
        if (startDate == null) {
            start = LocalDateTime.now();
        } else {
            start = LocalDateTime.parse(startDate);
        }
        if (endDate == null) {
            end = LocalDateTime.parse(endDate);
        }
        return null;
    }

    @GetMapping("{id}/reservations")
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
