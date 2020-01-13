package org.rent.cr.entity.attendent;

import org.rent.cr.entity.Price;
import org.rent.cr.entity.enums.PeriodType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "periods")
public class Period {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "period", fetch = FetchType.EAGER)
    private List<Price> prices;

    @Column(name = "periodname")
    private String name;

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
