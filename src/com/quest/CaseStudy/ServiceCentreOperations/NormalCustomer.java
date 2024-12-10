package com.quest.CaseStudy.ServiceCentreOperations;

import java.util.ArrayList;
import java.util.List;

public class NormalCustomer extends Customer
{
    private String membership;
    List<ServiceBooking> serviceBookings=new ArrayList<>();

    public NormalCustomer(String customerId, String name, String email, Vehicle vehicle, String membership) {
        super(customerId, name, email, vehicle);
        this.membership = "normal customer";
    }

    public void addServiceBooking(ServiceBooking booking) {
        this.serviceBookings.add(booking);
    }

    public List<ServiceBooking> getServiceBookings() {
        return serviceBookings;  // Always returns a valid list (empty if no bookings)
    }

    @Override
    public String toString() {
        return  super.toString()
        +", membership='" + membership;
    }
}
