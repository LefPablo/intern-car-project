package org.rent.cr.service.impl;

import org.rent.cr.dao.repo.OrderRepository;
import org.rent.cr.entity.Employee;
import org.rent.cr.entity.Order;
import org.rent.cr.entity.car.Car;
import org.rent.cr.entity.enums.CarStatus;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.service.CarService;
import org.rent.cr.service.EmployeeService;
import org.rent.cr.service.OrderService;
import org.rent.cr.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl extends CrudServiceImpl<Order, OrderRepository> implements OrderService {
    @Autowired
    private CarService carService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        super(orderRepository);
    }

    @Override
    public Order update(Order order, Order source) {
        Order result = super.update(order, source);
        carService.resolveCarStatus(order.getCar());
        return result;
    }

    @Override
    public void delete(Order order) {
        Car car = order.getCar();
        super.delete(order);
        repository.flush();
        carService.resolveCarStatus(car);
    }

    public boolean isLegalPeriod(Order order) throws NoEntityException {
        Car car =carService.findById(order.getCar().getId());
        List<Order> orders = repository.getOrdersLater(order.getStart());
        for (Order temp : orders) {
            if (EntityUtils.periodsIsCrossed(order.getStart(), order.getEnd(), temp.getStart(), temp.getEnd())) {
                return false;
            }
        }
        if (EntityUtils.periodIsCrossCurrentTime(order.getStart(), order.getEnd())) {
            if (car.getCarStatus() == CarStatus.BUSY) {
                return false;
            }
        }
        return true;
    }

    public void setEmployeeFromAuthentication(Order order) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)principal).getUsername();

        Employee employee = employeeService.findByEmail(username);
        order.setEmployee(employee);
    }
}
