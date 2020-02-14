package org.rent.cr.entity.car;

import com.fasterxml.jackson.annotation.*;
import org.rent.cr.dto.view.View;
import org.rent.cr.entity.GeneralEntity;
import org.rent.cr.entity.car.Car;
import org.rent.cr.entity.car.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "brands")
@JsonView(View.Public.class)
public class Brand extends GeneralEntity {
    @JsonIgnore
    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private List<Model> models;

    @Column(name = "brandname")
    private String name;

    public Brand() {
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
