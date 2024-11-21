package com.quest.oops.practice;

public class Main
{
    public static void main(String[] args)
    {
        Vehicle v=new Vehicle("Honda","Accord");
        Car c=new Car("Infinti","QX50",2017);
        Car c1=new Car("Mercedes","G63",2019);

        v.start();
        c.start();

        v.displayDetails();
        c.displayDetails();
        c1.displayDetails(c1.year);
        c1.setYearFinal(2020);
        c1.displayDetails(c1.year);
    }
}
