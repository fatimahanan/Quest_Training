package com.quest.oops.library;


import java.util.ArrayList;
import java.util.List;

public class Library extends LibraryFunctions
{
    List<Book> books;
    List<LibraryMember> libraryMembers;

    public Library()
    {
        books = new ArrayList<Book>();
        libraryMembers = new ArrayList<>();
    }

    @Override
    public void addBook(Book book)
    {
        System.out.println(book.getTitle()+" added successfully\n");
        books.add(book);
    }

    @Override
    public Book searchBook(String key)
    {
        boolean found = false;
        for(Book book : books)
        {
            if(String.valueOf(book.getIsbn()).equals(key) || book.getTitle().equals(key) || book.getAuthor().equals(key))
            {
                found = true;
                System.out.println("Book "+book.getTitle()+" found");
                return book;
            }
        }
        if(!found)
        {
            System.out.println("Book not found");
            return null;
        }
        return null;
    }

    @Override
    public void borrowBook(int memberID, long isbn)
    {
        LibraryMember member= searchMember(memberID);
        Book book=searchBook(String.valueOf(isbn));
        if(member!=null && book!=null && book.isAvailable())
        {
            member.borrowBooks(book); //function in book class to add to the list
            book.setAvailable(false); //setter set to false
            System.out.println(book.getTitle()+" book Borrowed\n");
        }
        else
        {
            System.out.println("Cannot borrow Book.\n");
            return;
        }
    }

    @Override
    public void returnBook(int memberID, long isbn, int noOfDaysOverdue)
    {
        LibraryMember member= searchMember(memberID);
        Book book=searchBook(String.valueOf(isbn));
        if(member!=null && book!=null && !book.isAvailable())
        {
            System.out.println(book.getTitle()+" book Returned\n");
            member.returnBooks(book,noOfDaysOverdue); //function in book class to add to the list
            book.setAvailable(true); //setter set to false
        }
        else
        {
            System.out.println("Cannot return Book.\n");
        }
    }

    @Override
    public void addMember(LibraryMember member)
    {
        libraryMembers.add(member);
    }

    @Override
    public void displayAllMembers()
    {
        for(LibraryMember member :libraryMembers)
        {
            System.out.println("Member ID : "+member.getMemberID());
            System.out.println("Name : "+member.getName());
            System.out.println("Phone number : "+member.getPhoneNo());
            System.out.println();
        }
    }

    @Override
    public void displayAvailableBooks()
    {
        for(Book book : books)
        {
            if(book.isAvailable())
            {
                System.out.println("ISBN : "+book.getIsbn());
                System.out.println("Title : "+book.getTitle());
                System.out.println("Author : "+book.getAuthor());
                System.out.println();
            }
        }
    }

    private LibraryMember searchMember(int memberID)
    {
        for (LibraryMember m : libraryMembers)
        {
            if (m.getMemberID() == memberID)
            {
                return m;
            }
        }
        return null;
    }


}
