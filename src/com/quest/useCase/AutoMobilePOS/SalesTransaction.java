package com.quest.useCase.AutoMobilePOS;

import java.util.List;

public class SalesTransaction
{
    private Customer customer;
    private List<Vehicle> vehiclesSoldToCustomer;
    private int totalAmount;

    public SalesTransaction(Customer customer, List<Vehicle> vehiclesSoldToCustomer) {
        this.customer = customer;
        this.vehiclesSoldToCustomer = vehiclesSoldToCustomer;
        this.totalAmount = calculateTotalAmount();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Vehicle> getVehiclesSoldToCustomer() {
        return vehiclesSoldToCustomer;
    }

    public void setVehiclesSoldToCustomer(List<Vehicle> vehiclesSoldToCustomer) {
        this.vehiclesSoldToCustomer = vehiclesSoldToCustomer;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int calculateTotalAmount()
    {
        for(Vehicle v: vehiclesSoldToCustomer)
        {
            totalAmount+=v.getPrice();
        }
        return totalAmount;
    }

    @Override
    public String toString() {
        return "SalesTransaction{" +
                "customer=" + customer +
                ", vehiclesSoldToCustomer=" + vehiclesSoldToCustomer +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
