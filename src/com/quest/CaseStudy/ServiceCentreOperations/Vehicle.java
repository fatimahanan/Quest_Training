package com.quest.CaseStudy.ServiceCentreOperations;

public class Vehicle
{
    private String vin; //vehicle identification no
    private String brand;
    private String model;
    private int year;  //of manufacture
    private double mileage;
    private String ownerName;
    private double originalPrice;

    public Vehicle(String vin, String brand, String model, int year, double mileage, String ownerName, double originalPrice) {
        this.vin = vin;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.ownerName = ownerName;
        this.originalPrice = originalPrice;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    @Override
    public String toString() {
        return "vin='" + vin + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", mileage=" + mileage +
                ", ownerName='" + ownerName + '\''+
                ", original price="+originalPrice;
    }
}
