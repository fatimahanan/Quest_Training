package com.quest.CaseStudy.ServiceCentreOperations;

import java.util.ArrayList;
import java.util.List;

public class Customer
{
    private String customerId;
    private String name;
    private String email;
    private Vehicle vehicle;
    private List<ServiceBooking> serviceBookings;

    public Customer(String customerId, String name, String email, Vehicle vehicle) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.vehicle = vehicle;
        this.serviceBookings=new ArrayList<>();
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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", vehicle=" + vehicle;
    }

    public void addServiceBooking(ServiceBooking booking) {
        serviceBookings.add(booking); // Add a booking for the customer
    }

    public List<ServiceBooking> getServiceBookings() {
        return serviceBookings; // Return the list of bookings
    }

}
