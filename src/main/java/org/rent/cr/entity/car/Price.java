package org.rent.cr.entity.car;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.rent.cr.dto.view.View;
import org.rent.cr.entity.GeneralEntity;
import org.rent.cr.entity.enums.PeriodType;

import javax.persistence.*;

@Data
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
}
