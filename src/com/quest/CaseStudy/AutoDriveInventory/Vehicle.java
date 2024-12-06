package com.quest.CaseStudy.AutoDriveInventory;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Vehicle implements Cloneable
{
    private String vehicleId;
    private String brand;
    private String model;

    public Vehicle(String vehicleId, String brand, String model, double price, LocalDate manufactureDate) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.manufactureDate = manufactureDate;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
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

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    private double price;
    private LocalDate manufactureDate;

    @Override
    public String toString() {
        return  "vehicleId='" + vehicleId + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", manufactureDate=" + manufactureDate;
    }

    @Override
    public Vehicle clone() {
        try {
            Vehicle clone = (Vehicle) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            clone.price=this.price*90/100; //10% discount
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("cannot clone..."+e.getMessage());
        }
    }
}
