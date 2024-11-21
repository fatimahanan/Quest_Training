package com.quest.oops.practice;

public class Car extends Vehicle
{
    int year;
    Car(String make, String model, int year)
    {
        super(make, model);
        this.year = year;
    }

    @Override
    public void start()
    {
        System.out.println("Car is starting");
    }

    public void displayDetails()
    {
        super.displayDetails();
    }

    public void displayDetails(int year)
    {
        super.displayDetails();
        System.out.println("Year: " + year);
    }

    public void setYearFinal(final int year)
    {
        this.year = year;
    }
}
