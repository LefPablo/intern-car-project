package org.rent.cr.dao.repo;

import org.rent.cr.entity.Fine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FineRepository extends JpaRepository<Fine, Integer>, JpaSpecificationExecutor<Fine> {
}
