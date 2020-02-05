package org.rent.cr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.rent.cr.entity.enums.Role;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "roles")
public class EmplRole extends GeneralEntity {
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "emplid")
    private Employee employee;

    @Enumerated(EnumType.STRING)
    @Column(name = "rolename")
    @NotEmpty(message = "Role must be set")
    private Role role;

    public EmplRole() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
