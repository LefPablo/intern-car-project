package org.rent.cr.service.impl;

import org.rent.cr.entity.Employee;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.service.EntityService;

import java.util.List;

public class EmployeeServiceImpl implements EntityService<Employee> {
    @Override
    public Employee findById(int id) throws NoEntityException {
        return null;
    }

    @Override
    public Employee save(Employee entity) {
        return null;
    }

    @Override
    public Employee update(Employee entity) {
        return null;
    }

    @Override
    public void delete(Employee entity) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Employee> findAll() {
        return null;
    }
}
