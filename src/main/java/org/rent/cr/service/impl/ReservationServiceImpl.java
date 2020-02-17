package org.rent.cr.service.impl;

import org.rent.cr.dao.repo.ReservationRepository;
import org.rent.cr.entity.Employee;
import org.rent.cr.entity.Equipment;
import org.rent.cr.entity.Order;
import org.rent.cr.entity.Reservation;
import org.rent.cr.exception.NotSavedException;
import org.rent.cr.exception.PeriodNotValidException;
import org.rent.cr.service.EmployeeService;
import org.rent.cr.service.OrderService;
import org.rent.cr.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ReservationServiceImpl extends CrudServiceImpl<Reservation, ReservationRepository> implements ReservationService {

    @Autowired
    OrderService orderService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        super(reservationRepository);
    }

    public Order makeOrder(Reservation reservation) throws PeriodNotValidException, NotSavedException {
        Order order = new Order();
        order.setCar(reservation.getCar());

        if (reservation.getStart().isBefore(reservation.getEnd())) {
            order.setStart(reservation.getStart());
            order.setEnd(reservation.getEnd());
        } else {
            throw new PeriodNotValidException(reservation.getStart(), reservation.getEnd());
        }

        List<Equipment> equipment = new ArrayList<>();
        equipment.addAll(reservation.getEquipmentList());

        order.setEquipmentList(equipment);
        order = orderService.save(order);
        return order;
    }

    public void setEmployeeFromAuthentication(Reservation reservation) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)principal).getUsername();

        Employee employee = employeeService.findByEmail(username);
        reservation.setEmployee(employee);
    }
}
