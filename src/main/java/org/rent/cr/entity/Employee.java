package org.rent.cr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.rent.cr.dto.view.View;
import org.rent.cr.entity.enums.EmplStatus;
import org.rent.cr.entity.enums.Role;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table (name = "empls")
@JsonView(View.Public.class)
public class Employee extends GeneralEntity {
    @OneToOne (optional=false)
    @JoinColumn (name="userid")
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private List<Order> orders;

    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private List<Reservation> reservations;

    @ElementCollection
    @CollectionTable(name = "roles", joinColumns = @JoinColumn(name = "emplid"))
    @Enumerated(EnumType.STRING)
    @Column(name = "rolename")
    private List<Role> roles;

    @Column(name = "emplemail")
    @NotEmpty(message = "Employee must be set")
    @Email(message = "Email is not correct")
    private String email;

    @Column(name = "emplpassword")
    @NotEmpty(message = "Password must be set")
    @Size(min = 6, message = "Password size must be 6 or bigger")
    private String password;

    @Column(name = "emplstatus")
    @NotNull(message = "Status must be set")
    @Enumerated(EnumType.STRING)
    private EmplStatus status;

    @Column(name = "emplposition")
    @NotEmpty(message = "Employee must have a position")
    private String position;

    @Column(name = "emplgotjob")
    private LocalDate gotjob;

    @Column(name = "emplenabled")
    private Boolean enabled = false;
}
