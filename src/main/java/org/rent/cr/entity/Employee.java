package org.rent.cr.entity;

import org.rent.cr.entity.enums.EmplStatus;
import org.rent.cr.entity.enums.Role;

import javax.persistence.*;

@Entity
@Table (name = "empls")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne (fetch=FetchType.LAZY, optional=false)
    @JoinColumn (name="userid")
    private User user;

    @Column(name = "emplemail")
    private String email;

    @Column(name = "emplpassword")
    private String password;

    @Column(name = "emplrole")
    private Role role;

    @Column(name = "emplstatus")
    private EmplStatus status;

    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public EmplStatus getStatus() {
        return status;
    }

    public void setStatus(EmplStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", status=" + status +
                '}';
    }
}
