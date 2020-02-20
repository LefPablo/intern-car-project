package org.rent.cr.service.impl.car;

import org.rent.cr.dao.repo.car.CarRepository;
import org.rent.cr.entity.Order;
import org.rent.cr.entity.car.Car;
import org.rent.cr.entity.enums.CarStatus;
import org.rent.cr.entity.enums.OrderStatus;
import org.rent.cr.service.CarService;
import org.rent.cr.service.impl.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
@Transactional
public class CarServiceImpl extends CrudServiceImpl<Car, CarRepository> implements CarService {

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        super(carRepository);
    }

    // if even one order is performed then set car status to 'BUSY' else if car status already 'BUSY' then set to 'AVAIL'
    public void resolveCarStatus(Car car) {
        List<Order> orders = car.getOrders();
        for (Order order : orders) {
            if (order.getOrderStatus() == OrderStatus.PERFORM) {
                car.setCarStatus(CarStatus.BUSY);
                return;
            }
        }
        if (car.getCarStatus() == CarStatus.BUSY) {
            car.setCarStatus(CarStatus.AVAIL);
        }
    }

    //return order that cross specific date or that are after this date
    @Override
    public Order getClosestOrder(Car car, LocalDateTime dateTime, boolean isCrossDateTime) {
        List<Order> orders = car.getOrders();

        orders.sort((o1, o2) -> {
            if (o1.getStart() != null && o2.getStart() != null) {
                return o1.getStart().compareTo(o2.getStart());
            } else if (o1.getStart() == null && o2.getStart() != null) {
                return -1;
            } else if (o1.getStart() != null && o2.getStart() == null) {
                return 1;
            } else {
                return 0;
            }
        });


        for (Order order : orders) {
            if (isCrossDateTime) {
                if (order.getEnd() != null && order.getEnd().isAfter(dateTime)) {
                    return order;
                }
            } else {
                if (order.getStart() != null && order.getStart().isAfter(dateTime)) {
                    return order;
                }
            }
        }
        return null;
    }

    @Override
    public List<Car> findCarsForPeriod(LocalDateTime start, LocalDateTime end) {
        return null;
    }

}
