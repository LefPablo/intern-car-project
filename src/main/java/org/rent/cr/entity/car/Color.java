package org.rent.cr.entity.car;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.rent.cr.entity.GeneralEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "colors")
public class Color extends GeneralEntity {
    @Column(name = "colorname")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "color")
    private List<Car> cars;

    public Color() {
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
