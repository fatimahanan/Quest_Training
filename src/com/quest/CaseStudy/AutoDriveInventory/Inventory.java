package com.quest.CaseStudy.AutoDriveInventory;

import java.util.*;

public class Inventory
{
    Set<Vehicle> vehicleSet;

    public Inventory() {
        this.vehicleSet = new HashSet<>();
    }

    public void addVehicle(Vehicle v)
    {
        vehicleSet.add(v);
    }

    public void removeVehicle(Vehicle v)
    {
        vehicleSet.remove(v);
    }

    public Vehicle getVehicleById(String vehicleId)
    {
        Iterator<Vehicle> iterator = vehicleSet.iterator();
        while (iterator.hasNext())
        {
            Vehicle temp=iterator.next();
            if(temp.getVehicleId().equals(vehicleId))
                return temp;
        }
        return null;
    }
    public void purchaseFromInventory(Customer c, String vehicleId, Map<Customer,Set<Vehicle>> customerMap) throws VehicleNotFoundException
    {
        Vehicle vehicle=getVehicleById(vehicleId);
        if(vehicle!=null)
        {
            Vehicle clonedVehicle=vehicle.clone();
            removeVehicle(vehicle);
            c.addPurchasedVehicle(clonedVehicle);
            customerMap.putIfAbsent(c, new HashSet<>());
            customerMap.get(c).add(clonedVehicle);
        }
        else
            throw new VehicleNotFoundException("Vehicle "+vehicleId+" not found");

    }

    public void displayInventory()
    {
        Iterator<Vehicle> iterator = vehicleSet.iterator();
        if(vehicleSet.isEmpty())
        {
            System.out.println("No vehicles in the inventory");
        }
        else
        {
            while (iterator.hasNext())
            {
                Vehicle v = iterator.next();
            }
        }
    }
}
