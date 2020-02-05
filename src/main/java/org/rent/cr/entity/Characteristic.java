package org.rent.cr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "characts")
public class Characteristic extends GeneralEntity {
    @JsonIgnore
    @ManyToOne (optional=false)
    @JoinColumn (name="equipid")
    private Equipment equipment;

    @Column(name = "charactname")
    private String name;

    public Characteristic() {
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
