package org.rent.cr.entity;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.rent.cr.dto.view.View;
import org.rent.cr.entity.car.Car;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

@Data
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
}
