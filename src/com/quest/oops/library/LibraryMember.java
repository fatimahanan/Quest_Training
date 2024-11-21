package com.quest.oops.library;

import java.util.*;

public class LibraryMember
{
    private int memberID;
    private String name;
    private long phoneNo;
    private List<Book> borrowedBooks;
    private int noOfDaysOverdue;

    public LibraryMember(int memberID, String name, long phoneNo) {
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

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBooks(Book book)
    {
        if(!borrowedBooks.contains(book))
            borrowedBooks.add(book);
    }

    public void returnBooks(Book book, int noOfDaysOverdue)
    {
        int fine = book.overdueBookFine(noOfDaysOverdue);  // Calculate overdue fine
        if (fine > 0)
        {
            System.out.println("You owe a fine of Rs " + fine + " for the book: " + book.getTitle());
        }
        borrowedBooks.remove(book);
    }

}
