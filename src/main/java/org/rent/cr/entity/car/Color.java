package org.rent.cr.entity.car;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import org.rent.cr.dto.view.View;
import org.rent.cr.entity.GeneralEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "colors")
@JsonView(View.Public.class)
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
