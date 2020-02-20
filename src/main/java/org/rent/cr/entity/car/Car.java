package org.rent.cr.entity.car;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.rent.cr.dto.view.View;
import org.rent.cr.entity.GeneralEntity;
import org.rent.cr.entity.Order;
import org.rent.cr.entity.Reservation;
import org.rent.cr.entity.enums.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Data
@Entity
@Table(name = "cars")
@JsonView(View.Public.class)
public class Car extends GeneralEntity {
    //Join
    @JsonView(View.Exclude.class)
    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<Image> images;

    @JsonView(View.Exclude.class)
    @ManyToMany
    @JoinTable (name="car_option",
            joinColumns=@JoinColumn (name="carid"),
            inverseJoinColumns=@JoinColumn(name="optionid"))
    private List<Option> options;

    @JsonView(View.Exclude.class)
    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<Price> prices;

    @JsonIgnore
    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<Order> orders;

    @JsonIgnore
    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    @ManyToOne
    @JoinColumn(name = "modelid")
    private Model model;

    @ManyToOne
    @JoinColumn(name = "colorid")
    private Color color;

    //Columns
    @Positive
    @Column(name = "caryear")
    private Integer year;

    @PositiveOrZero
    @Column(name = "cardoors")
    private Integer doors;

    @PositiveOrZero
    @Column(name = "cartrunk")
    private Integer trunk;

    @PositiveOrZero
    @Column(name = "carpassengers")
    private Integer passengers;

    @Column(name = "carconsum")
    private String consumption;

    @Column(name = "cardescr")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "carstatus")
    private CarStatus carStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "carbody")
    private Body body;

    @Enumerated(EnumType.STRING)
    @Column(name = "cartrans")
    private Transmission transmission;

    @Enumerated(EnumType.STRING)
    @Column(name = "carfuel")
    private Fuel fuel;

    @Enumerated(EnumType.STRING)
    @Column(name = "carclass")
    private CarClass carClass;
}
