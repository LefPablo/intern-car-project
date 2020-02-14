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
@JsonView(View.Public.class)
public class Reservation extends GeneralEntity {
    @JsonView(View.Exclude.class)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carid")
    private Car car;

    @JsonView(View.Exclude.class)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emplid")
    private Employee employee;

    @JsonView(View.Exclude.class)
    @ManyToMany
    @JoinTable(name = "reserv_equip",
            joinColumns = @JoinColumn(name = "reservid"),
            inverseJoinColumns = @JoinColumn(name = "equipid"))
    private List<Equipment> equipmentList;

    @JsonView(View.Exclude.class)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderid")
    private Order order;

    @Column(name = "reservname")
    @NotBlank (message = "Name must be not blank")
    private String name;

    @Column(name = "reservphone")
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
    private Boolean processed = false;

    public Reservation() {
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
