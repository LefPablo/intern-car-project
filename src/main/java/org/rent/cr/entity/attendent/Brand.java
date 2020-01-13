package org.rent.cr.entity.attendent;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "brands")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "brand")
    private List<Model> models;

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
