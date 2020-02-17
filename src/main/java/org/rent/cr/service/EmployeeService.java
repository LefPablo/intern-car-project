package org.rent.cr.service;

import org.rent.cr.entity.Employee;

public interface EmployeeService extends CrudService<Employee> {
    Employee findByEmail(String email);
}
