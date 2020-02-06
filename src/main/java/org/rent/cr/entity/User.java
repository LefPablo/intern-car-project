package org.rent.cr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends GeneralEntity {
    @OneToOne (mappedBy="user", fetch = FetchType.LAZY)
    private Employee employee;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Order> orders;

    @Column (name = "username")
    @NotEmpty(message = "Name must be set")
    private String name;

    @Column (name = "userage")
    @Min(value = 18, message = "User must be 18 or older")
    private Integer age;


    @Column (name = "userpassport")
    private String passport;

    @Column (name = "userphone")
    @NotEmpty(message = "User phone must be set")
    private String phone;

    @Column (name = "userdrivexp")
    @Min(value = 1, message = "Drive experience must be 1 and over")
    private Integer drivexp;

    @Column (name = "userdrivlic")
    private String drivlic;

    @Column (name = "useremail")
    @Email(message = "Email is not correct")
    private String email;

    public User() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
