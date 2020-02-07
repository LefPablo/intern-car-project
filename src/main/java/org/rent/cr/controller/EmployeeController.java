package org.rent.cr.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.rent.cr.dto.view.View;
import org.rent.cr.entity.Employee;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.exception.NotSavedException;
import org.rent.cr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("employees")
public class EmployeeController extends CrudController<Employee, EmployeeService> {
    EmployeeService employeeService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public EmployeeController(EmployeeService service) {
        super(service, "Employee");
        employeeService = service;
    }

    @Override
    public Object findById(@PathVariable("id") int id) throws NoEntityException {
        return super.findById(id);
    }
}
