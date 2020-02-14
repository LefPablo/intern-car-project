package org.rent.cr.service;

import org.rent.cr.entity.Order;
import org.rent.cr.entity.Reservation;
import org.rent.cr.exception.NotSavedException;
import org.rent.cr.exception.NotUpdatedException;
import org.rent.cr.exception.PeriodNotValidException;

public interface ReservationService extends EntityService<Reservation> {
    Order makeOrder(Reservation reservation) throws PeriodNotValidException, NotSavedException;
    void setEmployeeFromAuthentication(Reservation reservation) throws NotUpdatedException;
}
