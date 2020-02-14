package org.rent.cr.entity.car;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import org.rent.cr.dto.view.View;
import org.rent.cr.entity.GeneralEntity;
import org.rent.cr.entity.enums.PeriodType;

import javax.persistence.*;

@Entity
@Table(name = "prices")
@JsonView(View.Public.class)
public class Price extends GeneralEntity {
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "carid")
    private Car car;

    @Column(name = "pricevalue")
    private Float value;

    @Enumerated(EnumType.STRING)
    @Column(name = "priceperiod")
    private PeriodType periodType;

    public Price() {
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public PeriodType getPeriodType() {
        return periodType;
    }

    public void setPeriodType(PeriodType periodType) {
        this.periodType = periodType;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
