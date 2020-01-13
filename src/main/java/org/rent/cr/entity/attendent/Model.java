package org.rent.cr.entity.attendent;

import javax.persistence.*;

@Entity
@Table(name = "models")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
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
