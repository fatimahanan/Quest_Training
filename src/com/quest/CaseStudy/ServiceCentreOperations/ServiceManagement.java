package com.quest.CaseStudy.ServiceCentreOperations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ServiceManagement {
    private Map<Customer, ArrayList<ServiceBooking>> serviceBookings = new HashMap<>();

    // Method to add a service booking for a customer
    public void addServiceBooking(ServiceBooking serviceBooking) throws InvalidBookingException {
        // 1. Validate if the service date is in the future
        if (serviceBooking.getServiceDate().isBefore(LocalDateTime.now())) {
            throw new InvalidBookingException("Service date cannot be in the past.");
        }

        // 2. Check if a booking with the same ID already exists for the customer
        if (serviceBookings.containsKey(serviceBooking.getCustomer())) {
            for (ServiceBooking existingBooking : serviceBookings.get(serviceBooking.getCustomer())) {
                if (existingBooking.getBookingId().equals(serviceBooking.getBookingId())) {
                    throw new InvalidBookingException("Booking ID already exists.");
                }
            }
        }

        // 3. Add service booking to the map
        serviceBookings.computeIfAbsent(serviceBooking.getCustomer(), k -> new ArrayList<>()).add(serviceBooking);
    }

    // 4. Get all service bookings for all customers
    public Map<Customer, ArrayList<ServiceBooking>> getAllServiceBookings() {
        return serviceBookings;
    }

    // 5. Get service bookings for a specific customer
    public ArrayList<ServiceBooking> getServiceBookingsByCustomer(Customer customer) {
        return serviceBookings.getOrDefault(customer, new ArrayList<>());
    }

    // 6. Get service bookings by booking ID for validation or retrieval
    public ServiceBooking getServiceBookingById(String bookingId) {
        for (ArrayList<ServiceBooking> bookings : serviceBookings.values()) {
            for (ServiceBooking booking : bookings) {
                if (booking.getBookingId().equals(bookingId)) {
                    return booking;
                }
            }
        }
        return null; // Return null if no booking with the given ID is found
    }
}