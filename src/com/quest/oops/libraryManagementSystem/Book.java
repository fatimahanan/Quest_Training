package com.quest.oops.libraryManagementSystem;

public class Book
{
    private String title;
    private String author;
    private long isbn;

    public Book(String title, String author, long isbn) {
        this.title = title;
        this.author = author;
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

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString()
    {
        return "BOOK [Title: " + title + ", Author: " + author + ", ISBN: " + isbn+"]";
    }
}
