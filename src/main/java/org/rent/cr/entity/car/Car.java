package org.rent.cr.entity.car;

import org.rent.cr.entity.Order;
import org.rent.cr.entity.Reservation;
import org.rent.cr.entity.enums.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "car")
    private List<Image> images;

    @ManyToMany
    @JoinTable (name="car_option",
            joinColumns=@JoinColumn (name="carid"),
            inverseJoinColumns=@JoinColumn(name="optionid"))
    private List<Option> options;

    @OneToMany(mappedBy = "car")
    private List<Price> prices;

    @ManyToOne
    @JoinColumn(name = "brandid")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "modelid")
    private Model model;

    @ManyToOne
    @JoinColumn(name = "colorid")
    private Color color;

    @OneToMany(mappedBy = "car")
    private List<Order> orders;

    @OneToMany(mappedBy = "car")
    private List<Reservation> reservations;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "carstatus")
    private CarStatus carStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "carbody")
    private Body body;

    @Enumerated(EnumType.STRING)
    @Column(name = "cartrans")
    private Transmission transmission;

    @Enumerated(EnumType.STRING)
    @Column(name = "carfuel")
    private Fuel fuel;

    @Enumerated(EnumType.STRING)
    @Column(name = "carclass")
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

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
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
}
