package org.rent.cr.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Table(name = "equips")
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equipid")
    private Integer id;

    @OneToMany (mappedBy="equipment", fetch=FetchType.LAZY)
    private List<Characteristic> characteristics;

    @ManyToMany
    @JoinTable (name="order_equip",
            joinColumns=@JoinColumn (name="equipid"),
            inverseJoinColumns=@JoinColumn(name="orderid"))
    private List<Order> orders;

    @Column(name = "equipname")
    private String name;

    @Column(name = "equipprice")
    @Min(value = 0, message = "Price must be positive")
    private Float price;

    @Column(name = "equipimg")
    private String image;

    @Column(name = "equipdescr")
    private String descr;

    public Equipment() {
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

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
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
}
