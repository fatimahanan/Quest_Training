package com.quest.java8.bookStoreInventory;

public class Book
{
    private static final int DISCOUNT_PERCENTAGE=10;
    private String title;
    private String author;
    private int price;
    private int stock;


    public Book(String title, String author, int price, int stock)
    {
        this.title = title;
        this.author = author;
        this.price = price;
        this.stock = stock;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int calculateDiscount()
    {
        int temp=100-DISCOUNT_PERCENTAGE;
        return price*temp/100;
    }

    public void stockCheck(int quantity) throws OutOfStockException
    {
        if(quantity > this.stock)
            throw new OutOfStockException("\n"+title+" out of stock!\nRequested quantity ("+quantity+") exceeds stock ("+stock+")");
        else
        {
            this.stock -= quantity;
            System.out.println("\n"+title + " purchased.\nRemaining stock : " + stock);
        }
    }

    public void displayDetails()
    {
        System.out.println("Title : "+title);
        System.out.println("Author : "+author);
        System.out.println("Price : "+price);
        System.out.println("Stock : "+stock);
    }
}
