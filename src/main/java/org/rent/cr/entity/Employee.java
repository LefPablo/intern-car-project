package org.rent.cr.entity;

import org.rent.cr.entity.enums.EmplStatus;
import org.rent.cr.entity.enums.Role;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table (name = "empls")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emplid")
    private Integer id;

    @OneToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="userid")
    private User user;

    @OneToMany(mappedBy = "employee")
    private List<Order> orders;

    @OneToMany(mappedBy = "employee")
    private List<Reservation> reservations;

    @Column(name = "emplemail")
    private String email;

    @Column(name = "emplpassword")
    private String password;

    @Column(name = "emplrole")
    private Role role;

    @Column(name = "emplstatus")
    private EmplStatus status;

    @Column(name = "emplposition")
    private String position;

    @Column(name = "emplgotjob")
    private LocalDate gotjob;

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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDate getGotjob() {
        return gotjob;
    }

    public void setGotjob(LocalDate gotjob) {
        this.gotjob = gotjob;
    }
}
