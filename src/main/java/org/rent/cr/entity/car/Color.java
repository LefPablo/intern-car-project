package org.rent.cr.entity.car;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.rent.cr.dto.view.View;
import org.rent.cr.entity.GeneralEntity;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "colors")
@JsonView(View.Public.class)
public class Color extends GeneralEntity {
    @Column(name = "colorname")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "color")
    private List<Car> cars;
}
