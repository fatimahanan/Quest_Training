package com.quest.CaseStudy.ServiceCentreOperations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ServiceManagement {
    private Map<Customer, ArrayList<ServiceBooking>> serviceBookings = new HashMap<>();

    // Method to add a service booking for a customer
    public void addServiceBooking(ServiceBooking serviceBooking) throws InvalidBookingException {
        // validate if the service date is in the future
        if (serviceBooking.getServiceDate().isBefore(LocalDateTime.now())) {
            throw new InvalidBookingException("Service date cannot be in the past.");
        }

        // check if booking with the same ID already exists for the customer
        if (serviceBookings.containsKey(serviceBooking.getCustomer())) {
            for (ServiceBooking existingBooking : serviceBookings.get(serviceBooking.getCustomer())) {
                if (existingBooking.getBookingId().equals(serviceBooking.getBookingId())) {
                    throw new InvalidBookingException("Booking ID already exists.");
                }
            }
        }

        //add service booking to the map
        serviceBookings.computeIfAbsent(serviceBooking.getCustomer(), k -> new ArrayList<>()).add(serviceBooking);
    }

    //Get all service bookings for all customers
    public Map<Customer, ArrayList<ServiceBooking>> getAllServiceBookings() {
        return serviceBookings;
    }

    //get service bookings for a specific customer
    public ArrayList<ServiceBooking> getServiceBookingsByCustomer(Customer customer) {
        return serviceBookings.getOrDefault(customer, new ArrayList<>());
    }

    // get service bookings by booking ID for validation or retrieval
    public ServiceBooking getServiceBookingById(String bookingId) {
        for (ArrayList<ServiceBooking> bookings : serviceBookings.values()) {
            for (ServiceBooking booking : bookings) {
                if (booking.getBookingId().equals(bookingId)) {
                    return booking;
                }
            }
        }
        return null;
    }
}