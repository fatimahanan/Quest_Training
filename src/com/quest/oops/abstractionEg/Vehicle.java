package com.quest.oops.abstractionEg;

public abstract class Vehicle
{
    protected String manufacturer;
    protected String model;
    protected int year;

    public Vehicle(String manufacturer, String model, int year)
    {
        this.manufacturer=manufacturer;
        this.model=model;
        this.year=year;
    }
    public void displayDetails()
    {
        System.out.println("Manufacturer: "+manufacturer);
        System.out.println("Model: "+model);
        System.out.println("Year: "+year);
    }
    public void startEngine()
    {
        System.out.println("Starting engine...");
    }
    public void stopEngine()
    {
        System.out.println("Stopping engine...");
    }
    public abstract void drive();
}

