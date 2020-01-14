package org.rent.cr.entity.car;

import org.rent.cr.entity.car.Car;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "colors")
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "colorname")
    private String name;

    @OneToMany(mappedBy = "color")
    private List<Car> cars;

    public Color() {
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
