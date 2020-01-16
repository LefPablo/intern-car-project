package org.rent.cr.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Integer id;

    @OneToOne (mappedBy="user")
    private Employee employee;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @Column (name = "userage")
    @Min(value = 18, message = "User must be 18 or older")
    private Integer age;

    @Column (name = "userpassport")
    @NotBlank(message = "Passport must be not blank")
    private String passport;

    @Column (name = "userphone")
    @NotEmpty(message = "User phone must be set")
    private String phone;

    @Column (name = "userdrivexp")
    @Min(value = 1, message = "Drive experience must be 1 and over")
    private Integer drivexp;

    @Column (name = "userdrivlic")
    @NotBlank(message = "Driver license must be not blank")
    private String drivlic;

    @Column (name = "useremail")
    @Email(message = "Email is not correct")
    private String email;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getDrivexp() {
        return drivexp;
    }

    public void setDrivexp(Integer drivexp) {
        this.drivexp = drivexp;
    }

    public String getDrivlic() {
        return drivlic;
    }

    public void setDrivlic(String drivlic) {
        this.drivlic = drivlic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
