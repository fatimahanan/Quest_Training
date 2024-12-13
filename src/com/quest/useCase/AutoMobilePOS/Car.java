package com.quest.useCase.AutoMobilePOS;

public class Car extends Vehicle
{
    private int noOfSeats;

    public Car(int id, String brand, String model, int price, int quantityInStock, int noOfSeats) {
        super(id, brand, model, price, quantityInStock);
        this.noOfSeats = noOfSeats;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    @Override
    public String toString() {
        return super.toString()+" [Car - " +
                "noOfSeats=" + noOfSeats +
                ']';
    }
}
