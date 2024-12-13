package com.quest.useCase.AutoMobilePOS;

import java.util.ArrayList;
import java.util.List;

public class VehicleInventory<T extends Vehicle>
{
    private List<T> availableVehicleList; //inventory
    private List<SalesTransaction> saleTransactionList;

    public VehicleInventory()
    {
        this.availableVehicleList = new ArrayList<>();
        this.saleTransactionList = new ArrayList<>();
    }

    public void addVehicle(T v)
    {
        System.out.println("Vehicle "+v.getBrand()+" "+v.getModel()+" added successfully");
        availableVehicleList.add(v);
    }

    public void sellVehicle(Customer customer, List<T> vehicleToSell)
    {
        boolean isSold=false;
        List<T> soldVehicle=new ArrayList<>();
        for(T v : vehicleToSell)
        {
            boolean isFound=false;
            for(T vehicle: availableVehicleList)
            {
                if(v.getId()== vehicle.getId() && vehicle.getQuantityInStock()>0)
                {
                    isFound=true;
                    vehicle.updateQuantityInStock(1);
                    soldVehicle.add(vehicle);
                    break;
                }
            }
            if(!isFound)
            {
                System.out.println("Vehicle with id"+v.getId()+" not found");
            }
        }
        if(!soldVehicle.isEmpty())
        {
            List<Vehicle> soldVehiclesAsVehicle = new ArrayList<>(soldVehicle);
            SalesTransaction transaction = new SalesTransaction(customer,soldVehiclesAsVehicle);
            saleTransactionList.add(transaction);
            System.out.println("Sale completed: " + transaction);
        }
    }

    public void displayInventory()
    {
        System.out.println("\ndisplaying inventory...");
        for(T v:availableVehicleList)
        {
            System.out.println(v);
        }
    }

    public void displaySalesTransactions() {
        for (SalesTransaction transaction : saleTransactionList) {
            System.out.println(transaction);
        }
    }

    @Override
    public String toString() {
        return "VehicleInventory{" +
                "availableVehicleList=" + availableVehicleList +
                ", saleTransactionList=" + saleTransactionList +
                '}';
    }
}
