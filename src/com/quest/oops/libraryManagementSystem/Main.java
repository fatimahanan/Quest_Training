package com.quest.oops.libraryManagementSystem;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Book b1=new Book("The Story of My Life","Helen Keller",1900);
        Book b2=new Book("The Kite Runner","Khaled H",2013);
        Book b3=new Book("The Fault in Our Stars","John Green",2011);
        Book b4=new Book("Beach Read","Emily Burn",2020);

        Member m1=new Member("Hanan",1,"regular");
        Member m2=new Member("Skyler",2,"regular");
        PremiumMember m3=new PremiumMember("James",3);

        /*Scanner sc=new Scanner(System.in);
        int ch=0;
        do
        {
            System.out.println("1. Borrow book");
            System.out.println("2. Return book");
            System.out.println("3. View members");
            System.out.println("4. View available books");
            System.out.println("5. Exit");
            System.out.println("Enter your choice");
            ch=sc.nextInt();
            switch(ch)
            {
                case 1:
            }
        }*/

        m1.borrowBook(b1);
        m1.borrowBook(b2);
        m3.borrowBook(b3);

        m2.returnBook(b1);
        m1.returnBook(b2);

        System.out.println(m1.getName()+" has to pay a fine of Rs "+m1.calculateLateFee(10)+" for being 10 days late");
        System.out.println(m3.getName()+" has to pay a fine of Rs "+m3.calculateLateFee(10)+" for being 10 days late");

        System.out.println(m3);


    }
}
