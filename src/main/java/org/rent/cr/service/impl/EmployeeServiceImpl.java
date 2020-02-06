package org.rent.cr.service.impl;

import org.rent.cr.entity.Employee;
import org.rent.cr.dao.repo.EmployeeRepository;
import org.rent.cr.exception.NotSavedException;
import org.rent.cr.exception.NotUpdatedException;
import org.rent.cr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@Transactional
public class EmployeeServiceImpl extends EntityServiceImpl<Employee, EmployeeRepository> implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        super(employeeRepository, "Employee");
        this.employeeRepository = employeeRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Employee save(Employee entity) throws NotSavedException {
        entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));
        return super.save(entity);
    }

    @Override
    public Employee update(Employee entity) {
        entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));
        return super.update(entity);
    }

    @Override
    public Employee findByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }
}
