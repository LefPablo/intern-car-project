package org.rent.cr.dao.repo;

import org.rent.cr.dao.JpaRepositoryAndJpaSpecificationExecutor;
import org.rent.cr.entity.Period;
import org.rent.cr.entity.car.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodRepository extends JpaRepositoryAndJpaSpecificationExecutor<Period, Integer> {
}
