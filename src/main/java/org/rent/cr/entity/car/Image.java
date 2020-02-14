package org.rent.cr.entity.car;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import org.rent.cr.dto.view.View;
import org.rent.cr.entity.GeneralEntity;
import org.rent.cr.entity.car.Car;

import javax.persistence.*;

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

    public Image() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
