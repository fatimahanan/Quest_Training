package com.quest.CaseStudy.ServiceCentreOperations;

import java.time.Instant;
import java.time.LocalDateTime;

public class ServiceBooking<T>
{
    private String bookingId;
    private Customer customer;
    private LocalDateTime serviceDate;
    private String serviceType;
    private double cost;

    public ServiceBooking(String bookingId, Customer customer, LocalDateTime serviceDate, String serviceType, double cost) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.serviceDate = serviceDate;
        this.serviceType = serviceType;
        this.cost = cost;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(LocalDateTime serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "bookingId='" + bookingId + '\'' +
                ", customer=" + customer +
                ", serviceData=" + serviceDate +
                ", serviceType='" + serviceType + '\'' +
                ", cost=" + cost;
    }

}
