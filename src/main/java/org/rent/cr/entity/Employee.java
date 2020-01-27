package org.rent.cr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import org.rent.cr.dto.view.View;
import org.rent.cr.entity.enums.EmplStatus;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
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

    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private List<Order> orders;

    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private List<Reservation> reservations;

    @JsonView(View.PrivateEmpl.class)
    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
    private List<EmplRole> emplRoles;

    @Column(name = "emplemail")
    @Email(message = "Email is not correct")
    private String email;

    @Column(name = "emplpassword")
    @NotEmpty(message = "Password must be set")
    @Size(min = 6, message = "Password size must be 6 or bigger")
    private String password;

    @Column(name = "emplstatus")
    @NotEmpty(message = "Status must be set")
    private EmplStatus status;

    @Column(name = "emplposition")
    @NotEmpty(message = "Employee must have a position")
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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<EmplRole> getEmplRoles() {
        return emplRoles;
    }

    public void setEmplRoles(List<EmplRole> emplRoles) {
        this.emplRoles = emplRoles;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
