package org.rent.cr.entity;

import javax.persistence.*;

@Entity
@Table(name = "characts")
public class Characteristic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "charactid")
    private Integer id;

    @ManyToOne (optional=false)
    @JoinColumn (name="equipid")
    private Equipment equipment;

    @Column(name = "charactname")
    private String name;

    public Characteristic() {
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

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}
