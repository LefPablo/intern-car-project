package org.rent.cr.service.impl;

import org.rent.cr.entity.Order;
import org.rent.cr.entity.Reservation;
import org.rent.cr.entity.User;
import org.rent.cr.repo.ReservationRepository;
import org.rent.cr.service.OrderService;
import org.rent.cr.service.ReservationService;
import org.rent.cr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReservationServiceImpl extends EntityServiceImpl<Reservation, ReservationRepository>  implements ReservationService {
    private ReservationRepository reservationRepository;
    private OrderService orderService;
    private UserService userService;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository, UserService userService, OrderService orderService) {
        super(reservationRepository, "Reservation");
        this.reservationRepository = reservationRepository;
        this.userService = userService;
        this.orderService = orderService;
    }

    public void makeOrder(Reservation reservation) {
        if (reservation.getUser() == null) {
            User user = new User();
            user.setName(reservation.getName());
            user.setPhone(reservation.getPhone());
            user.setEmail(reservation.getEmail());
            user = userService.save(user);
            reservation.setUser(user);
        }
        Order order = new Order();
        order.setCar(reservation.getCar());
        order.setUser(reservation.getUser());

        order.setStart(reservation.getStart()); //TODO validate start to end period
        order.setEnd(reservation.getEnd());

        order.setEmployee(reservation.getEmployee()); //TODO get employee from session
        order.setEquipmentList(reservation.getEquipmentList());
        orderService.save(order);
    }
}
