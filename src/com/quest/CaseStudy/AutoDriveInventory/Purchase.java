package com.quest.CaseStudy.AutoDriveInventory;

import java.time.LocalDateTime;

public class Purchase
{
    private Vehicle vehicle;
    private LocalDateTime purchaseDateTime;

    public Purchase(Vehicle vehicle, LocalDateTime purchaseDateTime) {
        this.vehicle = vehicle;
        this.purchaseDateTime = purchaseDateTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getPurchaseDateTime() {
        return purchaseDateTime;
    }

    @Override
    public String toString() {
        return vehicle + " | Purchased at: " + purchaseDateTime;
    }
}