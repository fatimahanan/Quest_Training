package com.quest.oops.library;

public class Fiction extends Book
{
    private String genre;

    public Fiction(long isbn, String title, String author, int publicationYear, boolean isAvailable, String genre, double rating)
    {
        super(isbn, title, author, publicationYear, isAvailable);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
