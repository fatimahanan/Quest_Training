package com.quest.java8.bookStoreInventory;

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            Book[] b = new Book[5];
            b[0]=new Book("Book1","Author1",40,10);
            b[1]=new Book("Book2","Author2",50,10);
            b[2]=new Book("Book3","Author3",100,4);
            b[3]=new Book("Book4","Author4",20,25);
            b[4]=new SpecialEditionBook("SPBook5","Author5",48,5,"hardcover");

            System.out.println("Book details  :");
            for (Book book : b)
            {
                book.displayDetails();
                System.out.println("Discounted price : "+book.calculateDiscount());
                System.out.println();
            }

            System.out.println("Books above price 45 : ");
//            for (Book book : b)
//            {
//                if(book.getPrice()>45)
//                    System.out.println(book.getTitle());
                Arrays.stream(b)
                        .filter(book->book.getPrice()>45)
                                .forEach(book -> System.out.println(book.getTitle()));

            b[0].stockCheck(5);
            b[1].stockCheck(15);
        }
        catch (OutOfStockException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
