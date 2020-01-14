package org.rent.cr.entity.car;

import org.rent.cr.entity.car.Car;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "options")
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "optionname")
    private String name;

    @ManyToMany
    @JoinTable (name="car_option",
            joinColumns=@JoinColumn (name="optionid"),
            inverseJoinColumns=@JoinColumn(name="carid"))
    private List<Car> cars;

    public Option() {
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

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}