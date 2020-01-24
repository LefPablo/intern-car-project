package org.rent.cr.security.jwt;

import org.rent.cr.entity.EmplRole;
import org.rent.cr.entity.Employee;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public final class JwtUserFactory {
    public JwtUserFactory() {
    }

    public static JwtUser create(Employee employee){
        return new JwtUser(
                employee.getId(),
                employee.getUser().getName(),
                employee.getEmail(),
                employee.getPassword(),
                true,
                mapToGrantedAuthority(employee.getEmplRoles())
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthority(List<EmplRole> userRoles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (EmplRole role : userRoles) {
            authorities.add(new SimpleGrantedAuthority(role.getRole().name()));
        }
        return authorities;
    }
}
