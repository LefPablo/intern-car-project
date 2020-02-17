package org.rent.cr.entity.car;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.rent.cr.dto.view.View;
import org.rent.cr.entity.GeneralEntity;
import org.rent.cr.entity.car.Car;
import org.rent.cr.entity.car.Model;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "brands")
@JsonView(View.Public.class)
public class Brand extends GeneralEntity {
    @JsonIgnore
    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private List<Model> models;

    @Column(name = "brandname")
    private String name;
}
