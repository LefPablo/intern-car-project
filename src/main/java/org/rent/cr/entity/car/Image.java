package org.rent.cr.entity.car;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.rent.cr.dto.view.View;
import org.rent.cr.entity.GeneralEntity;
import org.rent.cr.entity.car.Car;

import javax.persistence.*;

@Data
@Entity
@Table(name = "images")
@JsonView(View.Public.class)
public class Image extends GeneralEntity {
    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "carid")
    private Car car;

    @Column(name = "imagepath")
    private String path;

    @Column(name = "imagepos")
    private Integer position;
}
