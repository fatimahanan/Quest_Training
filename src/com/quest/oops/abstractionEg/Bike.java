package com.quest.oops.abstractionEg;

public class Bike extends Vehicle
{
    public Bike(String manufacturer, String model, int year)
    {
        super(manufacturer, model, year);
    }

    @Override
    public void drive()
    {
        System.out.println("Riding the bike.");
    }

    public void messageBike()
    {
        System.out.println("Off-roading in a rocky terrain");
    }
}
