package org.rent.cr.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.rent.cr.dto.view.View;
import org.rent.cr.entity.Employee;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employee")
public class EmployeeController extends CrudController<Employee, EmployeeService> {
    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService service) {
        super(service, "Employee");
        employeeService = service;
    }

    @JsonView(View.PrivateEmpl.class)
    @Override
    public Employee findById(@PathVariable("id") int id) throws NoEntityException {
        return super.findById(id);
    }
}
