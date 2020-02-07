package org.rent.cr.service.impl;

import org.rent.cr.dao.repo.EmployeeRepository;
import org.rent.cr.entity.Employee;
import org.rent.cr.exception.NotSavedException;
import org.rent.cr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return repository.findByEmail(email);
    }
}
