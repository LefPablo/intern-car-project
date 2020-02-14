package org.rent.cr.dao.repo;

import org.rent.cr.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Integer>, JpaSpecificationExecutor<Equipment> {
}
