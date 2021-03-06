package org.rent.cr.dao.repo.car;

import org.rent.cr.entity.car.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends JpaRepository<Option, Integer>, JpaSpecificationExecutor<Option> {
}
