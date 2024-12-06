package com.quest.CaseStudy.AutoDriveInventory;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Purchase implements Serializable
{
    private static final long serialVersionUID = 1L;
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