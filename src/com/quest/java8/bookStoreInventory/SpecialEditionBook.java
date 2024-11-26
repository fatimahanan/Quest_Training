package com.quest.java8.bookStoreInventory;

public class SpecialEditionBook extends Book
{
    String specialFeature;
    public SpecialEditionBook(String title, String author, int price, int stock, String specialFeature)
    {
        super(title, author, price, stock);
        this.specialFeature = specialFeature;
    }

   @Override
    public void displayDetails()
   {
       super.displayDetails();
       System.out.println("Special Feature: " + specialFeature);
   }
}
