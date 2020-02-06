package org.rent.cr.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.rent.cr.entity.Employee;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeControllerTest {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    EmployeeService employeeService;

    @Test
    public void isMatched() throws NoEntityException {
        String password = "test";
        Employee employee = employeeService.findById(1);
        System.out.println(bCryptPasswordEncoder.matches(password, employee.getPassword()));
    }
}