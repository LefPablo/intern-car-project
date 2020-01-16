package org.rent.cr.service.impl;

import org.rent.cr.entity.EmplRole;
import org.rent.cr.repo.EmplRoleRepository;
import org.rent.cr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl extends EntityServiceImpl<EmplRole, EmplRoleRepository> implements RoleService {
    private EmplRoleRepository emplRoleRepository;

    @Autowired
    public RoleServiceImpl(EmplRoleRepository emplRoleRepository) {
        super(emplRoleRepository, "EmplRole");
        this.emplRoleRepository = emplRoleRepository;
    }
}
