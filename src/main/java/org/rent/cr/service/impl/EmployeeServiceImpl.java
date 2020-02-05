package org.rent.cr.service.impl;

import org.rent.cr.entity.Employee;
import org.rent.cr.dao.repo.EmployeeRepository;
import org.rent.cr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl extends EntityServiceImpl<Employee, EmployeeRepository> implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super(employeeRepository, "Employee");
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee findByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }
}
