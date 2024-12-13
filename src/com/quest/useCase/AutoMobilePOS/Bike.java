package com.quest.useCase.AutoMobilePOS;

public class Bike extends Vehicle
{
    private int engineCapacity;

    public Bike(int id, String brand, String model, int price, int quantityInStock, int engineCapacity) {
        super(id, brand, model, price, quantityInStock);
        this.engineCapacity = engineCapacity;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    @Override
    public String toString() {
        return super.toString()+" [Bike -" +
                "engineCapacity=" + engineCapacity +
                ']';
    }
}
