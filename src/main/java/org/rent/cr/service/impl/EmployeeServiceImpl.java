package org.rent.cr.service.impl;

import org.rent.cr.dao.repo.EmployeeRepository;
import org.rent.cr.entity.Employee;
import org.rent.cr.entity.enums.Role;
import org.rent.cr.exception.NotSavedException;
import org.rent.cr.service.EmployeeService;
import org.rent.cr.util.SecureUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl extends CrudServiceImpl<Employee, EmployeeRepository> implements EmployeeService {
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        super(employeeRepository);
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Employee save(Employee entity) throws NotSavedException {
        List<Role> roles = entity.getRoles();
        if (roles.contains(Role.ROLE_SUPERADMIN) || roles.contains(Role.ROLE_ADMIN)) {
            if (!SecureUtils.matchRoles(Role.ROLE_SUPERADMIN)) {
                throw new AccessDeniedException("For this action you must have role [" + Role.ROLE_SUPERADMIN + "]");
            }
        }
        entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));
        return super.save(entity);
    }

    @Override
    public Employee update(Employee entity) {
        List<Role> roles = entity.getRoles();
        if (roles.contains(Role.ROLE_SUPERADMIN) || roles.contains(Role.ROLE_ADMIN)) {
            if (!SecureUtils.matchRoles(Role.ROLE_SUPERADMIN)) {
                throw new AccessDeniedException("For this action you must have role [" + Role.ROLE_SUPERADMIN + "]");
            }
        }
        entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));
        return super.update(entity);
    }

    @Override
    public Employee findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
