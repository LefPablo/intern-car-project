package org.rent.cr.dao.repo;

import org.rent.cr.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer>, JpaSpecificationExecutor<Reservation> {
}
