package org.rent.cr.security;

import org.rent.cr.entity.Employee;
import org.rent.cr.security.jwt.JwtUser;
import org.rent.cr.security.jwt.JwtUserFactory;
import org.rent.cr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    private final EmployeeService employeeService;

    @Autowired
    public JwtUserDetailsService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeService.findByEmail(username);
        if (employee == null) {
            throw new UsernameNotFoundException(("Employee with username: " + username + " not found"));
        }
        JwtUser jwtUser = JwtUserFactory.create(employee);

        return jwtUser;
    }
}
