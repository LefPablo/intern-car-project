package org.rent.cr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.rent.cr.dto.view.View;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Data
@Entity
@Table(name = "fines")
@JsonView(View.Public.class)
public class Fine extends GeneralEntity {
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "orderid")
    private Order order;

    @Column(name = "finecost")
    @Min(value = 0, message = "Price must be positive")
    private Float price;

    @Column(name = "finecomm")
    private String comment;
}
