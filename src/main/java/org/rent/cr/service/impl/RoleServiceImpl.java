package org.rent.cr.service.impl;

import org.rent.cr.entity.EmplRole;
import org.rent.cr.dao.repo.EmplRoleRepository;
import org.rent.cr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl extends CrudServiceImpl<EmplRole, EmplRoleRepository> implements RoleService {

    @Autowired
    public RoleServiceImpl(EmplRoleRepository emplRoleRepository) {
        super(emplRoleRepository);
    }
}
