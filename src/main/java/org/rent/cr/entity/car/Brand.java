package org.rent.cr.entity.car;

import org.rent.cr.entity.car.Car;
import org.rent.cr.entity.car.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "brands")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brandid")
    private Integer id;

    @OneToMany(mappedBy = "brand")
    private List<Model> models;

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
}
