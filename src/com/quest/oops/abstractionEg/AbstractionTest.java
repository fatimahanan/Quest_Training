package com.quest.oops.abstractionEg;

public class AbstractionTest
{
    public static void main(String[] args)
    {
        Bike b=new Bike("Harley-Davidson","X440",2023);
        b.displayDetails();
        b.startEngine();
        b.drive();
        b.messageBike();
        b.stopEngine();
        System.out.println();
        Car c=new Car("Mercedes-Benz","G63",2013);
        c.displayDetails();
        c.startEngine();
        c.drive();
        c.messageCar();
        c.stopEngine();
    }
}
