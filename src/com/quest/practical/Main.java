package com.quest.practical;

import java.time.LocalDateTime;

public class Main
{
    public static void main(String[] args)
    {
        Library library = new LibraryImpl();

        Book book1 = new Book("B001", "Effective Java", "Joshua Bloch", true);
        Book book2 = new Book("B002", "Clean Code", "Robert C. Martin", true);

        library.addBook(book1);
        library.addBook(book2);

        Student student1 = new Student("S001", "John Doe", "10th Grade");

        boolean borrowed = library.borrowBook("B001", student1);
        System.out.println("Book borrowed: " + borrowed);

        System.out.println("Available books: " + library.availableBooks());

        boolean returned = library.returnBook("B001", student1);
        System.out.println("Book returned: " + returned);

        // Show borrow history
        System.out.println("Borrowed History: " + library.borrowedHistory());
    }
}

