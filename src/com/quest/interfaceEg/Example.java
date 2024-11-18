package com.quest.interfaceEg;

public class Example
{
    public static void main(String[] args)
    {
        Vehicle v=new Car();
        v.wheel();
        v.horn();

        Car c=new Car();
        c.engine();
        c.lights();
    }
}
