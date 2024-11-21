package com.quest.oops.library;

public abstract class LibraryFunctions
{
    public abstract void addBook(Book book);
    public abstract Book searchBook(String key);
    public abstract void borrowBook(int memberId, long isbn);
    public abstract void returnBook(int memberId, long isbn, int noOfDaysOverdue);
    public abstract void addMember(LibraryMember member);
    public abstract void displayAllMembers();
    public abstract void displayAvailableBooks();

}
