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
@Table(name = "options")
@JsonView(View.Public.class)
public class Option extends GeneralEntity {
    @JsonIgnore
    @ManyToMany
    @JoinTable (name="car_option",
            joinColumns=@JoinColumn (name="optionid"),
            inverseJoinColumns=@JoinColumn(name="carid"))
    private List<Car> cars;

    @Column(name = "optionname")
    private String name;
}
