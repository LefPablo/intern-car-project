package org.rent.cr.entity;

import org.rent.cr.entity.attendent.Period;

import javax.persistence.*;

@Entity
@Table(name = "prices")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pricevalue")
    private Float value;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "periodid")
    private Period period;

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
}
