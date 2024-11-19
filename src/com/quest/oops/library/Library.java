package com.quest.oops.library;


import java.util.ArrayList;
import java.util.List;

public class Library
{
    List<Book> books;
    List<LibraryMember> libraryMembers;

    public Library()
    {
        books = new ArrayList<Book>();
        libraryMembers = new ArrayList<>();
    }

    public void addBook(Book book)
    {
        books.add(book);
    }

    public Book searchBook(String key)
    {
        boolean found = false;
        for(Book book : books)
        {
            if(String.valueOf(book.getIsbn()).equals(key) || book.getTitle().equals(key) || book.getAuthor().equals(key))
            {
                found = true;
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

    public boolean borrowBook(int memberID, long isbn)
    {
        LibraryMember member=findMemberById(memberID);
        Book book=findBookByIsbn(isbn);
        if(member!=null && book!=null && book.isAvailable())
        {
            member.borrowBooks(isbn); //function in book class to add to the list
            book.setAvailable(false); //setter set to false
            System.out.println(book.getTitle()+" book Borrowed\n");
            return true;
        }
        else
        {
            System.out.println("Cannot borrow Book.\n");
            return false;
        }
    }

    public void returnBook(int memberID, long isbn)
    {
        LibraryMember member=findMemberById(memberID);
        Book book=findBookByIsbn(isbn);
        if(member!=null && book!=null && !book.isAvailable())
        {
            member.returnBooks(isbn); //function in book class to add to the list
            book.setAvailable(true); //setter set to false
            System.out.println(book.getTitle()+" book Returned\n");
        }
        else
        {
            System.out.println("Cannot return Book.\n");
        }
    }

    public void addMember(LibraryMember member)
    {
        libraryMembers.add(member);
    }

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

    private LibraryMember findMemberById(int memberID)
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

    private Book findBookByIsbn(long isbn)
    {
        for (Book b : books)
        {
            if (b.getIsbn() == isbn)
            {
                return b;
            }
        }
        return null;
    }


}
