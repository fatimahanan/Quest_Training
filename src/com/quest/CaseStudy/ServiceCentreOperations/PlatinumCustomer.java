package com.quest.CaseStudy.ServiceCentreOperations;


import java.util.ArrayList;
import java.util.List;

public class PlatinumCustomer extends Customer
{
    private int membershipPoints;
    List<ServiceBooking> serviceBookings=new ArrayList<>();

    public PlatinumCustomer(String customerId, String name, String email, Vehicle vehicle, int membershipPoints) {
        super(customerId, name, email, vehicle);
        this.membershipPoints = membershipPoints;
    }

    public int getMembershipPoints() {
        return membershipPoints;
    }

    public void setMembershipPoints(int membershipPoints) {
        this.membershipPoints = membershipPoints;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", membershipPoints=" + membershipPoints;
    }

    public void addServiceBooking(ServiceBooking booking) {
        this.serviceBookings.add(booking);
    }

    public List<ServiceBooking> getServiceBookings() {
        return serviceBookings;  // Always returns a valid list (empty if no bookings)
    }
}
