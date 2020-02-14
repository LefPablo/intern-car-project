package org.rent.cr.security.jwt;

import org.rent.cr.entity.Employee;
import org.rent.cr.entity.enums.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public final class JwtUserFactory {
    public JwtUserFactory() {
    }

    public static JwtUser create(Employee employee){
        return new JwtUser(
                employee.getEmail(),
                employee.getPassword(),
                employee.getEnabled(),
                mapToGrantedAuthority(employee.getRoles())
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthority(List<Role> userRoles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : userRoles) {
            authorities.add(new SimpleGrantedAuthority(role.name()));
        }
        return authorities;
    }
}
