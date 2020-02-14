package org.rent.cr.dao.repo.car;

import org.rent.cr.entity.car.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer>, JpaSpecificationExecutor<Model> {
}
