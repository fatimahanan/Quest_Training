package com.quest.CaseStudy.ServiceCentreOperations;

public class NormalCustomer extends Customer
{
    private String membership;

    public NormalCustomer(String customerId, String name, String email, Vehicle vehicle, String membership) {
        super(customerId, name, email, vehicle);
        this.membership = "normal customer";
    }

    @Override
    public String toString() {
        return  super.toString()
        +", membership='" + membership;
    }
}
