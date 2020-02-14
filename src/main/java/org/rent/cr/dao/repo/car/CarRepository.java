package org.rent.cr.dao.repo.car;

import org.rent.cr.entity.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer>, JpaSpecificationExecutor<Car> {
    @Query("SELECT distinct c.id FROM Car c join c.orders o WHERE o.end > ?1")
    List<Integer> getCarIdFromDate(LocalDateTime dateTime); //subrequest for filter to find free Cars after a given date
}
