package org.rent.cr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.rent.cr.entity.enums.EquipStatus;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Table(name = "equips")
public class Equipment extends GeneralEntity {
    @OneToMany (mappedBy="equipment", fetch=FetchType.LAZY)
    private List<Characteristic> characteristics;

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

    public Equipment() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String descr) {
        this.description = descr;
    }

    public List<Characteristic> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(List<Characteristic> characteristics) {
        this.characteristics = characteristics;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public EquipStatus getStatus() {
        return status;
    }

    public void setStatus(EquipStatus status) {
        this.status = status;
    }
}
