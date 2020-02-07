package org.rent.cr.entity.car;

import com.fasterxml.jackson.annotation.*;
import org.rent.cr.dto.view.View;
import org.rent.cr.entity.GeneralEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "models")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Model extends GeneralEntity {
    @JsonIgnore
    @OneToMany(mappedBy = "model")
    private List<Car> cars;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "brandid")
    private Brand brand;

    @Column(name = "modelname")
    private String name;

    public Model() {
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
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
