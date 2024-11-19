package com.quest.oops.library;

import java.util.*;

public class LibraryMember
{
    private int memberID;
    private String name;
    private long phoneNo;
    private List<Long> borrowedBooks;

    public LibraryMember(int memberID, String name, int phoneNo) {
        this.memberID = memberID;
        this.name = name;
        this.phoneNo = phoneNo;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public List<Long> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBooks(long isbn)
    {
        if(!borrowedBooks.contains(isbn))
            borrowedBooks.add(isbn);
    }

    public boolean returnBooks(long isbn)
    {
        return borrowedBooks.remove(isbn);
    }
}
