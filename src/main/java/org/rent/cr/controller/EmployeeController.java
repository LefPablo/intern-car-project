package org.rent.cr.controller;

import org.rent.cr.entity.Employee;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employees")
public class EmployeeController extends CrudController<Employee, EmployeeService> {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public EmployeeController(EmployeeService service) {
        super(service);
    }

    @Override
    public Object findById(@PathVariable("id") int id) throws NoEntityException {
        return super.findById(id);
    }

    @Override
    public Object update(@PathVariable("id") Employee entityFromDb, @RequestBody Employee entity) {
        return super.update(entityFromDb, entity);
    }
}
