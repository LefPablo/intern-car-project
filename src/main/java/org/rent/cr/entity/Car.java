package org.rent.cr.entity;

import org.rent.cr.entity.enums.*;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "caryear")
    private Integer year;

    @Column(name = "cardoors")
    private Integer doors;

    @Column(name = "cartrunk")
    private Integer trunk;

    @Column(name = "carpassengers")
    private Integer passengers;

    @Column(name = "carconsum")
    private String consumption;

    @Column(name = "cardescr")
    private String descr;

    private CarStatus carStatus;

    private Body body;

    private Transmission transmission;

    private Fuel fuel;

    private CarClass carClass;

    public Car() {
    }

    public Integer getId() {
        return id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getDoors() {
        return doors;
    }

    public void setDoors(Integer doors) {
        this.doors = doors;
    }

    public Integer getTrunk() {
        return trunk;
    }

    public void setTrunk(Integer trunk) {
        this.trunk = trunk;
    }

    public Integer getPassengers() {
        return passengers;
    }

    public void setPassengers(Integer passengers) {
        this.passengers = passengers;
    }

    public String getConsumption() {
        return consumption;
    }

    public void setConsumption(String consumption) {
        this.consumption = consumption;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public CarStatus getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    public CarClass getCarClass() {
        return carClass;
    }

    public void setCarClass(CarClass carClass) {
        this.carClass = carClass;
    }
}
