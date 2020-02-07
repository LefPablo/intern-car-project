package org.rent.cr.dto.car;

import com.fasterxml.jackson.annotation.JsonView;
import org.rent.cr.dto.view.View;
import org.rent.cr.entity.car.Brand;
import org.rent.cr.entity.car.Car;
import org.rent.cr.entity.car.Color;
import org.rent.cr.entity.car.Model;
import org.rent.cr.entity.enums.*;
import org.springframework.beans.BeanUtils;

public class CarDto extends Car { //extend car class
    @JsonView(View.Public.class)
    private Integer id;
    @JsonView(View.Public.class)
    private Brand brand;
    @JsonView(View.Public.class)
    private Model model;
    @JsonView(View.Public.class)
    private Color color;
    @JsonView(View.Public.class)
    private Integer year;
    @JsonView(View.Public.class)
    private Integer doors;
    @JsonView(View.Public.class)
    private Integer trunk;
    @JsonView(View.Public.class)
    private Integer passengers;
    @JsonView(View.Public.class)
    private String consumption;
    @JsonView(View.Public.class)
    private String description;
    @JsonView(View.Public.class)
    private CarStatus carStatus;
    @JsonView(View.Public.class)
    private Body body;
    @JsonView(View.Public.class)
    private Transmission transmission;
    @JsonView(View.Public.class)
    private Fuel fuel;
    @JsonView(View.Public.class)
    private CarClass carClass;

    public CarDto() {
    }

    public static CarDto carToDto(Car car) {
        CarDto carDro = new CarDto();
        BeanUtils.copyProperties(car, carDro);
        return carDro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
