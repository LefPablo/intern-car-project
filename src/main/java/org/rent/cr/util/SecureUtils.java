package org.rent.cr.util;

import org.rent.cr.dao.repo.EmployeeRepository;
import org.rent.cr.entity.Employee;
import org.rent.cr.entity.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SecureUtils {
    @Autowired
    private static EmployeeRepository employeeRepository;

    public static Employee getEmployeeFromAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return employeeRepository.findByEmail(authentication.getName());
        }
        return null;
    }

    public static boolean matchRoles(Role requiredRole) {
        Employee authentication = getEmployeeFromAuthentication();
        if (authentication != null) {
            return authentication.getRoles().contains(requiredRole);
        } else {
            return false;
        }
    }
}
