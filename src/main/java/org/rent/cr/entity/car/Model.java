package org.rent.cr.entity.car;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.rent.cr.dto.view.View;
import org.rent.cr.entity.GeneralEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "models")
@JsonView(View.Public.class)
public class Model extends GeneralEntity {
    @JsonIgnore
    @OneToMany(mappedBy = "model")
    private List<Car> cars;

    @ManyToOne
    @JoinColumn(name = "brandid")
    private Brand brand;

    @Column(name = "modelname")
    private String name;
}
