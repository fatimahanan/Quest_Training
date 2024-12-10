package com.quest.CaseStudy.ServiceCentreOperations;

public class CombustionEngineVehicle extends Vehicle
{

    private String fuelType;
    private double EngineCapacity;

    public CombustionEngineVehicle(String vin, String brand, String model, int year, double mileage, String ownerName, double originalPrice, String fuelType, double engineCapacity) {
        super(vin, brand, model, year, mileage, ownerName, originalPrice);
        this.fuelType = fuelType;
        EngineCapacity = engineCapacity;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public double getEngineCapacity() {
        return EngineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        EngineCapacity = engineCapacity;
    }

    @Override
    public String toString() {
        return super.toString()+
                ", fuelType='" + fuelType + '\'' +
                ", EngineCapacity=" + EngineCapacity;
    }
}
