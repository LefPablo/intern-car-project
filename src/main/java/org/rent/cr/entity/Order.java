package org.rent.cr.entity;

import org.rent.cr.entity.enums.OrderStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "orderprice")
    private Float price;

    @Column(name = "orderkilom")
    private Integer kilom;

    @Column(name = "orderstart")
    private LocalDateTime start;

    @Column(name = "orderend")
    private LocalDateTime end;

    @Column(name = "orderupd")
    private LocalDateTime updated;

    private OrderStatus orderStatus;

    public Order() {
    }

    public Integer getId() {
        return id;
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
}
