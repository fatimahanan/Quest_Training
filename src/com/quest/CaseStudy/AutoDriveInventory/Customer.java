package com.quest.CaseStudy.AutoDriveInventory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Customer
{
    private String customerId;
    private String name;
    private String email;
    private List<Purchase> purchasedVehicles;

    public Customer(String customerId, String name, String email) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.purchasedVehicles = new ArrayList<Purchase>();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Purchase> getPurchasedVehicles() {
        return purchasedVehicles;
    }

    public void setPurchasedVehicles(ArrayList<Purchase> purchasedVehicles) {
        this.purchasedVehicles = purchasedVehicles;
    }

    @Override
    public String toString() {
        return "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", purchasedVehicles=" + purchasedVehicles;
    }

    public void addPurchasedVehicle(Vehicle vehicle) {
        // Create a new Purchase with the current date and time
        Purchase purchase=new Purchase(vehicle, LocalDateTime.now());
        purchasedVehicles.add(purchase);
    }
}
