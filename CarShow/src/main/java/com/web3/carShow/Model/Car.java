package com.web3.carShow.Model;


import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Car {
    long id;
    String name;
    String description;
    String brand;
    String model;
    double price;
    String color;
    String motorType;
    String power;
    int placeNumber;
    String status;
    String type;

    public Car(long id, String name, String description, String brand, String model,
               double price, String color, String motor_type, String power,
               int placeNumber, String status, String type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.color = color;
        this.motorType = motor_type;
        this.power = power;
        this.placeNumber = placeNumber;
        this.status = status;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMotorType() {
        return motorType;
    }

    public void setMotor_type(String motor_type) {
        this.motorType = motor_type;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public int getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
