package org.rent.cr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import org.rent.cr.dto.view.View;

import javax.persistence.*;
import javax.validation.constraints.Min;

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

    public Fine() {
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
