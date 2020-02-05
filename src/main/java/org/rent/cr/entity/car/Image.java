package org.rent.cr.entity.car;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.rent.cr.entity.GeneralEntity;
import org.rent.cr.entity.car.Car;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Image extends GeneralEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "imageid")
    private Integer id;

    @Column(name = "imagepath")
    private String path;

    @Column(name = "imagepos")
    private Integer position;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "carid")
    private Car car;

    public Image() {
    }

    public Integer getId() {
        return id;
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
