package org.rent.cr.entity.car;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.rent.cr.entity.GeneralEntity;
import org.rent.cr.entity.Period;

import javax.persistence.*;

@Entity
@Table(name = "prices")
public class Price extends GeneralEntity {
    @Column(name = "pricevalue")
    private Float value;

    @ManyToOne
    @JoinColumn(name = "periodid")
    private Period period;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "carid")
    private Car car;

    public Price() {
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
