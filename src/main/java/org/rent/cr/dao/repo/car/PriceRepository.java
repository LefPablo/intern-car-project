package org.rent.cr.dao.repo.car;

import org.rent.cr.dao.JpaRepositoryAndJpaSpecificationExecutor;
import org.rent.cr.entity.car.Brand;
import org.rent.cr.entity.car.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepositoryAndJpaSpecificationExecutor<Price, Integer> {
}
