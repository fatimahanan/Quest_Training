package com.quest.practice_vars;

import java.util.Scanner;

public class InventoryManagement
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int noOfProducts=0;
        boolean startRangeFlag=true;
        while(startRangeFlag)
        {
            System.out.println("Enter the number of products (1-100): ");
            while (!sc.hasNextInt())                //checking if integer
            {
                System.out.println("Error! Enter a valid number (integer) in the range 1-100.");
                sc.next();
            }
            noOfProducts=sc.nextInt();
            if(noOfProducts<1 || noOfProducts>100)  //checking if within range
            {
                System.out.println("Error! Invalid range");
            }
            else
                startRangeFlag=false;
        }
        String[] products=new String[noOfProducts];
        int[][] inventory=new int[noOfProducts][2];  //columns : unit, price
        int[] quantitiesSold=new int[noOfProducts];
        //accepting input
        for(int i=0;i<noOfProducts;i++)
        {
            System.out.println("\nEnter name of product "+(i+1)+" : ");
            products[i]=sc.next();
            inventory[i][0]=stockValidation(sc);
            inventory[i][1]=priceValidation(sc);
            quantitiesSold[i]=unitsSoldValidation(sc,inventory[i][0]);
            inventory[i][0]-=quantitiesSold[i];
        }
        generateSalesReport(products,inventory,quantitiesSold);
        //inventoryShortageCheck(products,inventory,quantitiesSold);
        restockProducts(sc,products,inventory);
        findOutOfStockProducts(products,inventory);
    }


    private static void generateSalesReport(String[] products, int[][] inventory, int[] quantitiesSold)
    {
        System.out.println("-----------------------Sales Report---------------------------");
        double[] total_revenue=new double[products.length];
        double finalTotalRevenue=0;
        int index=0;
        System.out.println("Total revenue generated for each product :- ");
        for(String product : products)
        {
            int price=inventory[index][1];
            int quantity=quantitiesSold[index];
            total_revenue[index]=price*quantity;
            System.out.println("Product "+(index+1)+" : "+product+" - "+quantity+" units * $"+price+" : $"+total_revenue[index]);
            index++;
        }
        for(double revenue: total_revenue)
        {
            finalTotalRevenue+=revenue;
        }
        System.out.println("\nTotal revenue generated from all products : $"+finalTotalRevenue);
    }

    /*private static void inventoryShortageCheck(String[] products, int[][] inventory, int[] quantitiesSold)
    {
        System.out.println("----------------------Shortage check--------------------------");
        System.out.println("\nInventory Shortage Check:");
        for (int i=0; i<products.length; i++)
        {
            int stock=inventory[i][0];
            int sold=quantitiesSold[i];
            if (sold>stock)
            {
                System.out.println("Warning: Insufficient stock for " + products[i] + ". Sold " + sold + " units, but only " + stock + " units were available.");
            }
        }
    }*/

    private static void restockProducts(Scanner sc, String products[], int[][] inventory)
    {
        System.out.println("\n---------------------Restock Products-------------------------");
        System.out.println("Enter the name of product that has to be restocked : ");
        String restockProd=sc.next();
        boolean found=true;
        for(int i=0;i<products.length;i++)
        {
            if(products[i].equalsIgnoreCase(restockProd))
            {
                found=false;
            }
            System.out.println("Enter the number of units : ");
            int maxRestock=100-inventory[i][0];
            int units = -1;
            while (units < 1 || units > maxRestock)
            {
                while (!sc.hasNextInt())
                {
                    System.out.println("Error! Please enter a valid number (integer).");
                    sc.next();
                }
                units = sc.nextInt();
                if (units < 1||units>maxRestock)  //checking if stock quantity exceeds 100
                {
                    System.out.println("Error! Number of units must be between 1 and " + maxRestock + " units.");
                }
            }
            inventory[i][0]+=units;
            System.out.println("Restocking product '"+products[i]+"' with "+units+" units...");
            System.out.println("Updated stock for "+products[i]+" : "+inventory[i][0]+" units.");
            break;
        }
        if(found==true)
            System.out.println("Product not found.");
    }

    private static void findOutOfStockProducts(String[] products, int[][] inventory)
    {
        System.out.println("\n---------------------Out-of-Stock Products------------------");
        System.out.println("Products out of stock:");
        boolean out=true;
        for (int i=0; i<products.length; i++)
        {
            int stock=inventory[i][0];
            if(stock==0)
            {
                System.out.println(products[i]+" is out of stock.");
                out=false;
            }
        }
        if(out==true)
            System.out.println("All products are in stock");
    }


    private static int stockValidation(Scanner sc)
    {
        int num=-1;
        System.out.println("Enter the stock quantity in the range (1-100) : ");
        while(num<1||num>100)
        {
            while(!sc.hasNextInt())         //checking if units is integer
            {
                System.out.println("Error! invalid input. Enter in range (1=100)");
                sc.next();
            }
            num=sc.nextInt();
            if(num<1 || num>100)   //checking if unit is within range
            {
                System.out.println("Error! invalid input. Enter in range (1-100)");
            }
        }
        return num;
    }

    private static int unitsSoldValidation(Scanner sc, int inventory)
    {
        int num=-1;
        System.out.println("Enter the number of units sold : ");
        while(num<0 || num>inventory)
        {
            while(!sc.hasNextInt())         //checking if units is integer
            {
                System.out.println("Error! invalid input. Input must be non-negative integer (lesser than stock quantity).");
                sc.next();
            }
            num=sc.nextInt();
            if(num<0)   //checking if unit is non-negative
            {
                System.out.println("Error! Input must be non-negative integer (lesser than stock quantity). ");
            }
            else if (num>inventory)
            {
                System.out.println("Warning! Insufficient stock quantity. Enter number in the range (1-"+inventory+")");
            }
        }
        return num;
    }

    private static int priceValidation(Scanner sc)
    {
        int price=-1;
        System.out.println("Enter the price : ");
        while(price<0)
        {
            while(!sc.hasNextInt())         //checking if units is integer
            {
                System.out.println("Error! invalid input. Enter a positive integer");
                sc.next();
            }
            price=sc.nextInt();
            if(price<1)   //checking if unit is within range
            {
                System.out.println("Error! invalid input. Enter a non-negative integer");
            }
        }
        return price;
    }

}
