package com.quest.CaseStudy.ServiceCentreOperations;

public class ElectricVehicle extends Vehicle
{
    private double batteryCapacity;
    private double rangePerCharge;

    public ElectricVehicle(String vin, String brand, String model, int year, double mileage, String ownerName, double originalPrice, double batteryCapacity, double rangePerCharge) {
        super(vin, brand, model, year, mileage, ownerName, originalPrice);
        this.batteryCapacity = batteryCapacity;
        this.rangePerCharge = rangePerCharge;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public double getRangePerCharge() {
        return rangePerCharge;
    }

    public void setRangePerCharge(double rangePerCharge) {
        this.rangePerCharge = rangePerCharge;
    }

    @Override
    public String toString()
    {
        return super.toString()+
                ", batteryCapacity=" + batteryCapacity +
                ", rangePerCharge=" + rangePerCharge;
    }
}
