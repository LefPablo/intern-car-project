package org.rent.cr.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany (fetch=FetchType.LAZY, mappedBy="user")
    private List<Employee> employee;

    @Column (name = "userage")
    private Integer age;

    @Column (name = "userpassport")
    private String passport;

    @Column (name = "userphone")
    private String phone;

    @Column (name = "userdrivexp")
    private Integer drivexp;

    @Column (name = "userdrivlic")
    private String drivlic;

    @Column (name = "useremail")
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

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", passport='" + passport + '\'' +
                ", phone='" + phone + '\'' +
                ", drivexp=" + drivexp +
                ", drivlic='" + drivlic + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
