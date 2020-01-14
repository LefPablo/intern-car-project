package org.rent.cr.repo;

import org.rent.cr.entity.car.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Integer> {
}
