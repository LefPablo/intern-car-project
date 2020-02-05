package org.rent.cr.dao.repo;

import org.rent.cr.dao.JpaRepositoryAndJpaSpecificationExecutor;
import org.rent.cr.entity.Reservation;
import org.rent.cr.entity.car.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepositoryAndJpaSpecificationExecutor<Reservation, Integer> {
}
