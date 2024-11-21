package com.quest.oops.libraryManagementSystem;

import java.util.ArrayList;

public class Member implements LibraryOperations
{
    private String name;
    private int id;
    private String membershipType;
    protected ArrayList<Book> borrowedBooks;

    public Member(String name, int id, String membershipType) {
        this.name = name;
        this.id = id;
        this.membershipType = membershipType;
        borrowedBooks = new ArrayList<Book>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book)
    {
        if(borrowLimit())
        {
            borrowedBooks.add(book);
            System.out.println(name+" borrowed book '"+book.getTitle()+"'");
        }
        else
        {
            System.out.println(name+" exceeded borrow limit! Cannot borrow...");
        }

    }

    public boolean borrowLimit()
    {
        return borrowedBooks.size()<2;
    }

    public void returnBook(Book book)
    {
        if(borrowedBooks.contains(book))
        {
            borrowedBooks.remove(book);
            System.out.println(name+" returned book '"+book.getTitle()+"'");
        }
        else
        {
            System.out.println(name+" has not borrowed book! Cannot return book...");
        }
    }

    public int calculateLateFee(final int noOfDaysLate)
    {
        return 5*noOfDaysLate;
    }

    @Override
    public String toString()
    {
        return "Member [name=" + name + ", id=" + id + ", membershipType=" + membershipType + ", Borrowed books=" + borrowedBooks + "]";
    }
}
