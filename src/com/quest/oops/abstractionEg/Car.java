package com.quest.oops.abstractionEg;

public class Car extends Vehicle
{
    public Car(String manufacturer, String model, int year)
    {
        super(manufacturer, model, year);
    }

    @Override
    public void drive()
    {
        System.out.println("Driving the car.");
    }

    public void messageCar()
    {
        System.out.println("It is a 5 seater");
    }

}
