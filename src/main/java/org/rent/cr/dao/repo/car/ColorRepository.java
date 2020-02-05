package org.rent.cr.dao.repo.car;

import org.rent.cr.dao.JpaRepositoryAndJpaSpecificationExecutor;
import org.rent.cr.entity.car.Brand;
import org.rent.cr.entity.car.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepositoryAndJpaSpecificationExecutor<Color, Integer> {
}
