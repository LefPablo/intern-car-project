package org.rent.cr.entity.car;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import org.rent.cr.dto.view.View;
import org.rent.cr.entity.car.Car;
import org.rent.cr.entity.car.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "brands")
public class Brand {
    @JsonView(View.Public.Private.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brandid")
    private Integer id;

    @JsonView(View.Public.Private.class)
    @OneToMany(mappedBy = "brand")
    private List<Model> models;

    @JsonIgnore
    @OneToMany(mappedBy = "brand")
    private List<Car> cars;

    @Column(name = "brandname")
    private String name;

    public Brand() {
    }

    public Integer getId() {
        return id;
    }

        public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
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
