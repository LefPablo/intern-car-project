package org.rent.cr.service;

import org.rent.cr.entity.Order;
import org.rent.cr.entity.car.Car;

import java.time.LocalDateTime;
import java.util.List;

public interface CarService extends EntityService<Car> {
    void resolveCarStatus(Car car);
    Order getClosestOrder(Car car, LocalDateTime dateTime, boolean isCrossDateTime);
    List<Car> findCarsForPeriod(LocalDateTime start, LocalDateTime end);
}
