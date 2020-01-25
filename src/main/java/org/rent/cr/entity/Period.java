package org.rent.cr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.rent.cr.entity.car.Price;
import org.rent.cr.entity.enums.PeriodType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "periods")
public class Period {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "periodid")
    private Integer id;

    @JsonIgnore
    @OneToMany(mappedBy = "period")
    private List<Price> prices;

    @Column(name = "periodname")
    @NotEmpty(message = "Name must be set")
    @NotBlank(message = "Name must be not blank")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "periodtype")
    private PeriodType periodType;

    public Period() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PeriodType getPeriodType() {
        return periodType;
    }

    public void setPeriodType(PeriodType periodType) {
        this.periodType = periodType;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }
}
