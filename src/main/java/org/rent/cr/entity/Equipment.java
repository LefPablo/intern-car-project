package org.rent.cr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.rent.cr.dto.view.View;
import org.rent.cr.entity.enums.EquipStatus;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;

@Data
@Entity
@Table(name = "equips")
@JsonView(View.Public.class)
public class Equipment extends GeneralEntity {
    @ElementCollection
    @CollectionTable(name = "characts", joinColumns = @JoinColumn(name = "equipid"))
    @Column(name = "charactname")
    private List<String> characteristics;

    @JsonIgnore
    @ManyToMany
    @JoinTable (name="order_equip",
            joinColumns=@JoinColumn (name="equipid"),
            inverseJoinColumns=@JoinColumn(name="orderid"))
    private List<Order> orders;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "reserv_equip",
            joinColumns = @JoinColumn(name = "equipid"),
            inverseJoinColumns = @JoinColumn(name = "reservid"))
    private List<Reservation> reservations;

    @Column(name = "equipname")
    private String name;

    @Column(name = "equipprice")
    @Min(value = 0, message = "Price must be positive")
    private Float price;

    @Column(name = "equipimg")
    private String image;

    @Column(name = "equipdescr")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "equipstatus")
    private EquipStatus status;
}
