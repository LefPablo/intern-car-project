package org.rent.cr.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "fines")
public class Fine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fineid")
    private Integer id;

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

    public Integer getId() {
        return id;
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
