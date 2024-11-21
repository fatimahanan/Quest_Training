package com.quest.oops.library;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Library lib = new Library();
        Book b1 = new Fiction(3211928, "The Kite Runner", "Khaled Hosseini", 2003, true, "drama");
        lib.addBook(b1);
        Book b2 = new NonFiction(8912988, "The Story of My Life", "Helen Keller", 1900, true, "autobiography");
        lib.addBook(b2);
        Book b3 = new Fiction(7321334, "A Thousand Splendid Suns", "Khaled Hosseini", 2007, true, "drama");
        lib.addBook(b3);

        LibraryMember m1 = new LibraryMember(1, "Hanan", 70023997);
        lib.addMember(m1);
        LibraryMember m2 = new LibraryMember(2, "Michael", 72349997);
        lib.addMember(m2);

        int ch=0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\nWelcome to the Library Management System");
            System.out.println("1. View all available books");
            System.out.println("2. View all library members");
            System.out.println("3. Borrow a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. Search for a Book");
            System.out.println("6. Add book");
            System.out.println("7. Add member");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    lib.displayAvailableBooks();
                    break;
                case 2:
                    lib.displayAllMembers();
                    break;
                case 3: //borrow
                    System.out.println("Enter member id : ");
                    int borrowId = sc.nextInt();
                    System.out.println("Enter isbn : ");
                    long borrowIsbn = sc.nextLong();
                    lib.borrowBook(borrowId, borrowIsbn);
                    break;
                case 4: //return
                    System.out.println("Enter member id : ");
                    int returnId = sc.nextInt();
                    System.out.println("Enter isbn : ");
                    long returnIsbn = sc.nextLong();
                    System.out.println("Enter no. of days overdue : ");
                    int noOfDaysOverdue = sc.nextInt();
                    lib.returnBook(returnId, returnIsbn, noOfDaysOverdue);
                    break;
                case 5: //search
                    System.out.println("Enter isbn/author/title : ");
                    String key = sc.next();
                    lib.searchBook(key);
                    break;
                case 6: //add book
                    System.out.println("Enter isbn : ");
                    long addIsbn = sc.nextLong();
                    sc.nextLine();
                    System.out.println("Enter title : ");
                    String addTitle = sc.nextLine();
                    System.out.println("Enter author : ");
                    String addAuthor = sc.nextLine();
                    System.out.println("Enter publication year : ");
                    int addYear = sc.nextInt();
                    System.out.println("Enter if available (true/false): ");
                    boolean ifAvailable = sc.nextBoolean();
                    Book book=new Book(addIsbn, addTitle, addAuthor, addYear, ifAvailable);
                    lib.addBook(book);
                    break;
                case 7: //add member
                    System.out.print("Enter member ID: ");
                    int newMemberId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter member name: ");
                    String newMemberName = sc.nextLine();
                    System.out.print("Enter Phone Number: ");
                    long newMemberPhone = sc.nextLong();
                    LibraryMember newMember = new LibraryMember(newMemberId, newMemberName, newMemberPhone);
                    lib.addMember(newMember);
                    System.out.println("New member added successfully!");
                    break;
                case 8: //exit
                    System.out.print("Exiting... ");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while(ch != 8);

        /*System.out.println("Available Books : ");
        lib.displayAvailableBooks();

        System.out.println("\nLibrary Members : ");
        lib.displayAllMembers();

        System.out.println("Searching for Book by Khaled Hosseini");
        lib.searchBook("Khaled Hosseini");
        System.out.println();


        lib.borrowBook(1,8912988);
        System.out.println("\nUpdated Available Book List after borrowing : ");
        lib.displayAvailableBooks();

        lib.returnBook(1,8912988,3);
        System.out.println("\nUpdated Available Book List after returning : ");
        lib.displayAvailableBooks();

        Book b4=new Fiction(56223789,"Alchemist","Paulo Coelho",1995,true,"drama");
        System.out.println("Adding new book...");
        lib.addBook(b4);
        System.out.println("\nUpdated Available Book List after adding : ");
        lib.displayAvailableBooks();*/
    }
}
