package com.quest.CaseStudy.ServiceCentreOperations;


public class PlatinumCustomer extends Customer
{
    private int membershipPoints;

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
}
