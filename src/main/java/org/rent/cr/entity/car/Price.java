package org.rent.cr.entity.car;

import org.rent.cr.entity.Period;
import org.rent.cr.entity.car.Car;

import javax.persistence.*;

@Entity
@Table(name = "prices")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "priceid")
    private Integer id;

    @Column(name = "pricevalue")
    private Float value;

    @ManyToOne
    @JoinColumn(name = "periodid")
    private Period period;

    @ManyToOne
    @JoinColumn(name = "carid")
    private Car car;

    public Price() {
    }

    public Integer getId() {
        return id;
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
