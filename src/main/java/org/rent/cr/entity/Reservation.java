package org.rent.cr.entity;

import org.rent.cr.entity.car.Car;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservs")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservid")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "carid")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "emplid")
    private Employee employee;

    @Column(name = "reservname")
    @NotEmpty (message = "Name must be set")
    @NotBlank (message = "Name must be not blank")
    private String name;

    @Column(name = "reservphone")
    @NotEmpty (message = "Phone must be set")
    @NotBlank (message = "Phone must be not blank")
    private String phone;

    @Column(name = "reservstart")
    private LocalDateTime start;

    @Column(name = "reservend")
    private LocalDateTime end;

    @Column(name = "reservupd")
    private LocalDateTime updated;

    @Column(name = "reservproces")
    @NotEmpty(message = "'Processed' field must be set (boolean)")
    private boolean processed;

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

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
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
}
