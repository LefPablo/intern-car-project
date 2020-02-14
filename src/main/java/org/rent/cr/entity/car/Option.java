package org.rent.cr.entity.car;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import org.rent.cr.dto.view.View;
import org.rent.cr.entity.GeneralEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "options")
@JsonView(View.Public.class)
public class Option extends GeneralEntity {
    @JsonIgnore
    @ManyToMany
    @JoinTable (name="car_option",
            joinColumns=@JoinColumn (name="optionid"),
            inverseJoinColumns=@JoinColumn(name="carid"))
    private List<Car> cars;

    @Column(name = "optionname")
    private String name;

    public Option() {
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
