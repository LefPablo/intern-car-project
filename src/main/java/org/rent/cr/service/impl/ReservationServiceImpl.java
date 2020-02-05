package org.rent.cr.service.impl;

import org.rent.cr.entity.*;
import org.rent.cr.exception.NotSavedException;
import org.rent.cr.exception.NotValidException;
import org.rent.cr.repo.ReservationRepository;
import org.rent.cr.service.EmployeeService;
import org.rent.cr.service.OrderService;
import org.rent.cr.service.ReservationService;
import org.rent.cr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ReservationServiceImpl extends EntityServiceImpl<Reservation, ReservationRepository>  implements ReservationService {
    private ReservationRepository reservationRepository;
    private OrderService orderService;
    private EmployeeService employeeService;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository, OrderService orderService, EmployeeService employeeService) {
        super(reservationRepository, "Reservation");
        this.reservationRepository = reservationRepository;
        this.orderService = orderService;
        this.employeeService = employeeService;
    }

    public Order makeOrder(Reservation reservation) throws NotValidException, NotSavedException {
        Order order = new Order();
        order.setCar(reservation.getCar());

        if (reservation.getStart().isBefore(reservation.getEnd())) { //TODO make general method for validate period
            order.setStart(reservation.getStart());
            order.setEnd(reservation.getEnd());
        } else {
            throw new NotValidException("Period is not valid: start date must be early then end date");
        }

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)principal).getUsername();

        Employee employee = employeeService.findByEmail(username);
        order.setEmployee(employee);

        //Made this loop because Hibernate throw exception "Found shared references to a collection: org.rent.cr.entity.Order.equipmentList; nested exception is org.hibernate.HibernateException: Found shared references to a collection: org.rent.cr.entity.Order.equipmentList"
        List<Equipment> equipment = new ArrayList<>();
        for (Equipment equip : reservation.getEquipmentList()) {
            equipment.add(equip);
        }

        order.setEquipmentList(equipment);
        order = orderService.save(order); //throw exception if save not success
        reservation.setProcessed(true);
        return order;
    }
}
