package org.rent.cr.entity;

import com.fasterxml.jackson.annotation.JsonView;
import org.rent.cr.dto.view.View;
import org.rent.cr.entity.car.Car;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "reservs")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservid")
    private Integer id;

    @JsonView(View.PrivateReserv.class)
    @ManyToOne
    @JoinColumn(name = "carid")
    private Car car;

    @JsonView(View.PrivateReserv.class)
    @ManyToOne
    @JoinColumn(name = "emplid")
    private Employee employee;

    @JsonView(View.PrivateReserv.class)
    @ManyToMany
    @JoinTable(name = "reserv_equip",
            joinColumns = @JoinColumn(name = "reservid"),
            inverseJoinColumns = @JoinColumn(name = "equipid"))
    private List<Equipment> equipmentList;

    @JsonView(View.PrivateReserv.class)
    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;



    @Column(name = "reservname")
    @NotEmpty (message = "Name must be set")
    @NotBlank (message = "Name must be not blank")
    private String name;

    @Column(name = "reservphone")
    @NotEmpty (message = "Phone must be set")
    @NotBlank (message = "Phone must be not blank")
    private String phone;

    @Column(name = "reservemail")
    private String email;

    @Column(name = "reservstart")
    private LocalDateTime start;

    @Column(name = "reservend")
    private LocalDateTime end;

    @Column(name = "reservupd")
    private LocalDateTime updated;

    @Column(name = "reservproces")
    private Boolean processed;

    public Reservation() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public Boolean getProcessed() {
        return processed;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Equipment> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(List<Equipment> equipmentList) {
        this.equipmentList = equipmentList;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", car=" + car +
                ", employee=" + employee +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", equipmentList=" + equipmentList +
                ", user=" + user +
                ", email='" + email + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", updated=" + updated +
                ", processed=" + processed +
                '}';
    }
}
