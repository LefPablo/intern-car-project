package org.rent.cr.service.impl;

import org.rent.cr.dao.repo.EmployeeRepository;
import org.rent.cr.entity.Employee;
import org.rent.cr.entity.enums.Role;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.exception.NotSavedException;
import org.rent.cr.service.EmployeeService;
import org.rent.cr.util.SecureUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl extends CrudServiceImpl<Employee, EmployeeRepository> implements EmployeeService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super(employeeRepository);
    }

    @Override
    public Employee findById(int id) throws NoEntityException {
        Employee employee = super.findById(id);
        Employee registered = repository.findByEmail(SecureUtils.getUsernameFromAuthentication());
        SecureUtils.checkCredentials(Role.ROLE_SUPERADMIN, registered.getRoles(), employee.getRoles(), Role.ROLE_SUPERADMIN);
        return employee;
    }

    @Override
    public Employee save(Employee employee) throws NotSavedException {
        Employee registered = repository.findByEmail(SecureUtils.getUsernameFromAuthentication());
        SecureUtils.checkCredentials(Role.ROLE_SUPERADMIN, registered.getRoles(), employee.getRoles(), Role.ROLE_SUPERADMIN, Role.ROLE_ADMIN);
        employee.setPassword(bCryptPasswordEncoder.encode(employee.getPassword()));
        return super.save(employee);
    }

    @Override
    public Employee update(Employee employee, Employee source) {
        Employee registered = repository.findByEmail(SecureUtils.getUsernameFromAuthentication());
        SecureUtils.checkCredentials(Role.ROLE_SUPERADMIN, registered.getRoles(), employee.getRoles(), Role.ROLE_SUPERADMIN, Role.ROLE_ADMIN);
        if (source.getPassword() != null) {
            source.setPassword(bCryptPasswordEncoder.encode(employee.getPassword()));
        }
        return super.update(employee, source);
    }

    @Override
    public Employee findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
