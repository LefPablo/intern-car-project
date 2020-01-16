package org.rent.cr.repo;

import org.rent.cr.entity.EmplRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmplRoleRepository extends JpaRepository<EmplRole, Integer> {
}
