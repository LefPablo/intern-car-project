package org.rent.cr.service.impl;

import org.rent.cr.entity.Reservation;
import org.rent.cr.repo.ReservationRepository;
import org.rent.cr.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReservationServiceImpl extends EntityServiceImpl<Reservation, ReservationRepository>  implements ReservationService {
    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        super(reservationRepository, "Reservation");
        this.reservationRepository = reservationRepository;
    }
}
