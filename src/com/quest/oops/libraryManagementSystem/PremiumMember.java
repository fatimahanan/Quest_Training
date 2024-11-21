package com.quest.oops.libraryManagementSystem;

public class PremiumMember extends Member
{

    public PremiumMember(String name, int id)
    {
        super(name, id, "premium");
    }

    @Override
    public boolean borrowLimit()
    {
        return super.borrowedBooks.size()<5;
    }

    @Override
    public int calculateLateFee(final int noOfDaysLate)
    {
        return 1*noOfDaysLate;
    }

    @Override
    public String toString()
    {
        return "PREMIUM MEMBER [name=" + getName() + ", id=" + getId() + ", membershipType=" + getMembershipType() + ", Borrowed books=" + getBorrowedBooks() + "]";
    }
}
