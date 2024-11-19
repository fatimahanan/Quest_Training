package com.quest.oops.library;

public class Main
{
    public static void main(String[] args)
    {
        Library lib = new Library();
        Book b1=new Book(3211928,"The Kite Runner","Khaled Hosseini",2003,true);
        lib.addBook(b1);
        Book b2=new Book(8912988,"Pride and Prejudice","Jane Austen",1850,true);
        lib.addBook(b2);
        Book b3=new Book(7321334,"A Thousand Splendid Suns","Khaled Hosseini",2007,true);
        lib.addBook(b3);

        LibraryMember m1=new LibraryMember(1,"Hanan",70023997);
        lib.addMember(m1);
        LibraryMember m2=new LibraryMember(2,"Michael",72349997);
        lib.addMember(m2);

        System.out.println("Available Books : ");
        lib.displayAvailableBooks();

        System.out.println("\nLibrary Members : ");
        lib.displayAllMembers();

        lib.searchBook("Khaled Hosseini");

        lib.borrowBook(1,8912988);
        System.out.println("\nUpdated Available Book List after borrowing : ");
        lib.displayAvailableBooks();

        lib.returnBook(1,8912988);
        System.out.println("\nUpdated Available Book List after returning : ");
        lib.displayAvailableBooks();

        Book b4=new Fiction(56223789,"Alchemist","Paulo Coelho",1995,true,"Drama",5.2);
        System.out.println("Added new book");
        lib.addBook(b4);
        lib.displayAvailableBooks();
    }
}
