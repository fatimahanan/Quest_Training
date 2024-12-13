package com.quest.useCase.AutoMobilePOS;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        VehicleInventory<Vehicle> inventory =new VehicleInventory<>();

        Vehicle v1=new Car(1,"honda","accord",1000,4,5);
        Vehicle v2=new Car(2,"honda","accord",2000,6,4);
        Vehicle v3=new Bike(1,"Harley Davidson","Sportster",3000,8,1200);
        Vehicle v4=new Bike(2,"royal enfield","himalayan",4000,3,2000);
        inventory.addVehicle(v1);
        inventory.addVehicle(v2);
        inventory.addVehicle(v3);
        inventory.addVehicle(v4);

        Customer c1=new Customer(1,"paul");
        List<Vehicle> vehiclesToSell = new ArrayList<>();
        vehiclesToSell.add(v1);
        vehiclesToSell.add(v3);
        inventory.displayInventory();

        inventory.sellVehicle(c1,vehiclesToSell);
        inventory.displayInventory();
    }


}
