package org.rent.cr.entity.car;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "models")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "modelid")
    private Integer id;

    @OneToMany(mappedBy = "model")
    private List<Car> cars;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brandid")
    private Brand brand;

    @Column(name = "modelname")
    private String name;

    public Model() {
    }

    public Integer getId() {
        return id;
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
}
