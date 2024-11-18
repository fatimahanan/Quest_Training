package com.quest.interfaceEg;

public class Car extends Vehicle2 implements Vehicle
{
    @Override
    public void wheel()
    {
        System.out.println("wheel in Car class");
    }

    @Override
    public void horn()
    {
        System.out.println("horn in Car class");
    }

    void engine()
    {
        System.out.println("engine in Car class");
    }

    void lights()
    {
        System.out.println("lights in Car class");
    }
}
