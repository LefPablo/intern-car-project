package org.rent.cr.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import org.rent.cr.dto.view.View;
import org.rent.cr.entity.car.Car;
import org.rent.cr.entity.enums.OrderStatus;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order extends GeneralEntity {
    @ManyToMany
    @JoinTable (name="order_equip",
            joinColumns=@JoinColumn (name="orderid"),
            inverseJoinColumns=@JoinColumn(name="equipid"))
    private List<Equipment> equipmentList;

    @OneToMany(mappedBy = "order")
    private List<Fine> fines;

    @ManyToOne
    @JoinColumn(name = "carid")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "emplid")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

    @OneToOne(mappedBy = "order", fetch = FetchType.LAZY)
    private Reservation reservation;

    @Column(name = "orderprice")
    @Min(value = 0, message = "Price must be positive")
    private Float price;

    @Column(name = "orderkilom")
    @Min(value = 0, message = "Kilometers must be positive")
    private Integer kilom;

    @Column(name = "orderstart")
    private LocalDateTime start;

    @Column(name = "orderend")
    private LocalDateTime end;

    @Column(name = "orderupd")
    private LocalDateTime updated;

    @Enumerated(EnumType.STRING)
    @Column(name = "orderstatus")
    private OrderStatus orderStatus;

    public Order() {
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getKilom() {
        return kilom;
    }

    public void setKilom(Integer kilom) {
        this.kilom = kilom;
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

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<Equipment> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(List<Equipment> equipmentList) {
        this.equipmentList = equipmentList;
    }

    public List<Fine> getFines() {
        return fines;
    }

    public void setFines(List<Fine> fines) {
        this.fines = fines;
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

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
