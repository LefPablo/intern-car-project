package org.rent.cr.controller;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.extern.slf4j.Slf4j;
import org.rent.cr.dto.view.View;
import org.rent.cr.entity.Order;
import org.rent.cr.entity.Reservation;
import org.rent.cr.entity.car.Car;
import org.rent.cr.entity.car.Image;
import org.rent.cr.entity.car.Option;
import org.rent.cr.entity.car.Price;
import org.rent.cr.exception.IllegalActionException;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.exception.NotSavedException;
import org.rent.cr.service.CarService;
import org.rent.cr.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("cars")
public class CarController {

    @Autowired
    CarService service;

    @GetMapping("{id}/prices")
    public List<Price> findByIdPrices(@PathVariable("id") int id) throws NoEntityException {
        return ((Car) findById(id)).getPrices();
    }

    @GetMapping("{id}/orders")
    public List<Order> findByIdOrders(@PathVariable("id") int id) throws NoEntityException {
        return ((Car) findById(id)).getOrders();
    }

    @GetMapping("{id}/closestOrder")
    public Order findByIdClosestOrder(@PathVariable("id") int id, @RequestParam(name = "dateTime", required = false) String dateTime, @RequestParam(name = "isCross", defaultValue = "true",required = false) boolean isCrossDateTime) throws NoEntityException {
        LocalDateTime time = EntityUtils.parseTimeToLocalDateTime(dateTime);
        return service.getClosestOrder(service.findById(id), time, isCrossDateTime);
    }

    @GetMapping("{id}/reservations")
    public List<Reservation> findByIdReservations(@PathVariable("id") int id) throws NoEntityException {
        return ((Car) findById(id)).getReservations();
    }

    @GetMapping("{id}/options")
    public List<Option> findByIdOptions(@PathVariable("id") int id) throws NoEntityException {
        return ((Car) findById(id)).getOptions();
    }

    @GetMapping("{id}/images")
    public List<Image> findByIdImages(@PathVariable("id") int id) throws NoEntityException {
        return ((Car) findById(id)).getImages();
    }

    @JsonView(View.Public.class)
    @GetMapping("all")
    public Object findAll() {
        return service.findAll();
    }

    @JsonView(View.Public.class)
    @GetMapping
    public Object getPage(@RequestParam(name = "page", defaultValue = "1") Integer page, @RequestParam(name = "per_page", defaultValue = "20") Integer size, @RequestParam(name = "sort", required = false) String field, @RequestParam(name = "filter", required = false) String filter) {
        String order = null;
        if (field != null) {
            String[] params = field.split("\\|");
            if (params.length == 2) {
                order = params[1];
                field = params[0];
            }
        }
        Page<Car> result = service.getPage(page, size, field, order, filter);
        return result;
    }

    @JsonView(View.Private.class)
    @GetMapping("{id}")
    public Object findById(@PathVariable("id") int id) throws NoEntityException {
        Car entity = service.findById(id);
        return entity;
    }

    @JsonView(View.Private.class)
    @PostMapping
    public Object save(@RequestBody Car entity) throws NotSavedException, IllegalActionException, NoEntityException {
        entity =  service.save(entity);
        log.info("Car added {id=" + entity.getId() + "}");
        return entity;
    }

    @JsonView(View.Private.class)
    @PutMapping("{id}")
    public Object update(@PathVariable("id") Car entityFromDb, @RequestBody Car entity) {
        entity =  service.update(entityFromDb, entity);
        log.info("Car updated {id=" + entity.getId() + "}");
        return entity;
    }

    @DeleteMapping("deleteAll")
    public Object deleteAll() {
        long count = service.deleteAll();
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("message", "Car" + " all records deleted {count=" + count + "}");
        log.info("Car all records deleted {count=" + count + "}");
        return responseMap;
    }

    @DeleteMapping("{id}")
    public Object delete(@PathVariable("id") Car entity) throws NoEntityException {
        service.delete(entity);
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("message", "Car was deleted {id=" + entity.getId() + "}");
        log.info("Car deleted");
        return responseMap;
    }
}
