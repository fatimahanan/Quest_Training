package com.quest.oops.library;

import java.util.Date;

public class Book
{

    private long isbn;
    private String title;
    private String author;
    private int publicationYear;
    private boolean isAvailable;

    public Book(long isbn, String title, String author,int publicationYear, boolean isAvailable)
    {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isAvailable = isAvailable;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void checkAvailability()
    {
        if(isAvailable)
            System.out.println(title+" ("+isbn+") is available.");
        else
            System.out.println(title+" ("+isbn+") not available in store.");
    }


}
