package com.quest.oops.practice;

public class Vehicle
{
    protected String manufacturer;
    protected String model;

    Vehicle(String manufacturer, String model)
    {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public void start()
    {
        System.out.println("Vehicle started");
    }

    public void displayDetails()
    {
        System.out.println("\nManufacturer: "+manufacturer);
        System.out.println("Model: "+model);
    }
}
