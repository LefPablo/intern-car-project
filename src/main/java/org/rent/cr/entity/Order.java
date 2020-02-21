package org.rent.cr.entity;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.rent.cr.dto.view.View;
import org.rent.cr.entity.car.Car;
import org.rent.cr.entity.enums.OrderStatus;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
@JsonView(View.Public.class)
public class Order extends GeneralEntity {
    @JsonView(View.Exclude.class)
    @ManyToMany
    @JoinTable (name="order_equip",
            joinColumns=@JoinColumn (name="orderid"),
            inverseJoinColumns=@JoinColumn(name="equipid"))
    private List<Equipment> equipmentList;

    @JsonView(View.Exclude.class)
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Fine> fines;

    @JsonView(View.Exclude.class)
    @ManyToOne
    @JoinColumn(name = "carid")
    private Car car;

    @JsonView(View.Exclude.class)
    @ManyToOne
    @JoinColumn(name = "emplid")
    private Employee employee;

    @JsonView(View.Exclude.class)
    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

    @JsonView(View.Exclude.class)
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
}
