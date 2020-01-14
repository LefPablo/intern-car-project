package org.rent.cr.service.impl;

import org.rent.cr.entity.Reservation;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.service.EntityService;

import java.util.List;

public class ReservationServiceImpl implements EntityService<Reservation> {
    @Override
    public Reservation findById(int id) throws NoEntityException {
        return null;
    }

    @Override
    public Reservation save(Reservation entity) {
        return null;
    }

    @Override
    public Reservation update(Reservation entity) {
        return null;
    }

    @Override
    public void delete(Reservation entity) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Reservation> findAll() {
        return null;
    }
}
