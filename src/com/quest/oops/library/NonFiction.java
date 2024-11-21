package com.quest.oops.library;

public class NonFiction extends Book
{
    String category;
    public NonFiction(long isbn, String title, String author, int publicationYear, boolean isAvailable, String category)
    {
        super(isbn, title, author, publicationYear, isAvailable);
        this.category = category;
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    @Override
    public int overdueBookFine(int noOfDays)
    {
        return noOfDays*5;
    }
}
