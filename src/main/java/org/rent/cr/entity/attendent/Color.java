package org.rent.cr.entity.attendent;

import javax.persistence.*;

@Entity
@Table(name = "colors")
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "colorname")
    private String name;

    public Color() {
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
}
