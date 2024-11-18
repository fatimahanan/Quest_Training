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
        int[][] inventory=new int[noOfProducts][2];  //columns : units, price
        int[] quantitiesSold=new int[noOfProducts];

        //accepting input
        for(int i=0;i<noOfProducts;i++)
        {
            System.out.println("\nEnter name of product "+(i+1)+" : ");
            products[i]=sc.next();
            inventory[i][0]=stockValidation(sc);    //stock
            inventory[i][1]=priceValidation(sc,"");    //price
            quantitiesSold[i]=unitsSoldValidation(sc,inventory[i][0]);
            inventory[i][0]-=quantitiesSold[i];     //subtracting quantity sold from stock.
        }
        boolean repeat=true;
        while(repeat)
        {
            System.out.println("\nMenu");
            System.out.println("1. Generate Sales Report");     //total revenue for each product
            System.out.println("2. Restock Product");
            System.out.println("3. Sell Product");
            System.out.println("4. Generate Sales Summary (based on price range)");
            System.out.println("5. Out of Stock products");
            System.out.println("6. Display Inventory");
//            System.out.println("7. Inventory Shortage Check");
            System.out.println("7. Exit");
            System.out.println("Enter your choice: ");
            while(!sc.hasNextInt())
            {
                System.out.println("Enter valid choice (1-5) : ");
            }
            int ch=sc.nextInt();
            switch(ch)
            {
                case 1:
                    generateSalesReport(products, inventory, quantitiesSold);
                    break;
                case 2:
                    restockProducts(sc, products, inventory);
                    break;
                case 3:
                    sellProducts(sc, products, inventory, quantitiesSold);
                    break;
                case 4:
                    generateSalesSummary(sc, products, inventory);
                    break;
                case 5:
                    findOutOfStockProducts(products, inventory);
                    break;
                case 6:
                    displayInventory(products, inventory);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    repeat=false;
                    break;
//                case 7:
//                    inventoryShortageCheck(products, inventory, quantitiesSold);
//                    break;
                default:
                    System.out.println("Error! Invalid choice. Enter a valid choice. (1-6) : ");
            }
        }
    }


    private static void generateSalesReport(String[] products, int[][] inventory, int[] quantitiesSold)
    {
        System.out.println("-------------------------------Sales Report------------------------------");
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
        System.out.println("-------------------------------------------------------------------------");
    }

    private static void restockProducts(Scanner sc, String[] products, int[][] inventory)
    {
        System.out.println("\n---------------------------Restock Products----------------------------");
        boolean found=false;
        while(!found)
        {
            System.out.println("Enter the name of product that has to be restocked : ");
            String restockProd=sc.next();
            for(int i=0;i<products.length;i++)
            {
                if(products[i].equalsIgnoreCase(restockProd))
                {
                    found=true;
                    System.out.println("Enter the number of units : ");
                    int maxRestock=100-inventory[i][0];        //max stock for a prod is 100
                    int units=restockValidation(sc, maxRestock);
                    inventory[i][0]+=units;
                    System.out.println("Restocking product '"+products[i]+"' with "+units+" units...");
                    System.out.println("Updated stock for "+products[i]+" : "+inventory[i][0]+" units.");
                    break;
                }
            }
            if(found==false)
                System.out.println("Product not found. Enter valid product name");
        }
        System.out.println("-------------------------------------------------------------------------");
    }

    private static void sellProducts(Scanner sc, String[] products, int[][] inventory, int[] quantitiesSold)
    {
        System.out.println("\n----------------------------Sell Products------------------------------");
        boolean found=false;
        while(!found)
        {
            System.out.println("Enter the name of product that has to be sold : ");
            String sellProd=sc.next();
            for(int i=0;i<products.length;i++)
            {
                if(products[i].equalsIgnoreCase(sellProd))
                {
                    found=true;
                    int units=unitsSoldValidation(sc,inventory[i][0]);
                    inventory[i][0]-=units;         //updating stock
                    quantitiesSold[i]+=units;       //updating units sold
                    System.out.println("Selling "+units+" units of "+products[i]+"...");
                    System.out.println("Updated stock for "+products[i]+" : "+inventory[i][0]+" units.");
                    break;
                }
            }
            if(found==false)
                System.out.println("Product not found. Enter valid product name");
        }
        System.out.println("-------------------------------------------------------------------------");
    }

    /*private static void inventoryShortageCheck(String[] products, int[][] inventory, int[] quantitiesSold)
    {
        System.out.println("\n------------------------Inventory Shortage Check-----------------------");
        System.out.println("\nInventory Shortage Check:");
        for (int i=0; i<products.length; i++)
        {
            int stock=inventory[i][0];
            int sold=quantitiesSold[i];
            if (stock<=sold)
            {
                System.out.println("Warning: Insufficient stock for " + products[i]);
            }
        }
        System.out.println("-------------------------------------------------------------------------");
    }*/


    private static void generateSalesSummary(Scanner sc, String[] products, int[][] inventory)
    {
        System.out.println("\n--------------------Sales summary (based on price)---------------------");
        System.out.println("Enter the price range of products.");
        int minPrice=priceValidation(sc,"minimum ");
        int maxPrice=priceValidation(sc,"maximum ");
        System.out.println("Products within the price range ("+minPrice+"-"+maxPrice+") : ");
        boolean found=false;
        for(int i=0;i<products.length;i++)
        {
            if(inventory[i][1]>=minPrice && inventory[i][1]<=maxPrice)
            {
                System.out.println(products[i]);
                found=true;
            }
        }
        if(found==false)
            System.out.println("Oops! No products within the mentioned price range.");
        System.out.println("-------------------------------------------------------------------------");
    }

    private static void findOutOfStockProducts(String[] products, int[][] inventory)
    {
        System.out.println("\n-------------------------Out-of-Stock Products-------------------------");
        boolean out=true;
        for (int i=0; i<products.length; i++)
        {
            int stock=inventory[i][0];
            if(stock==0)
            {
                System.out.println(products[i]);
                out=false;
            }
        }
        if(out==true)
            System.out.println("\n All products are in stock!");
        System.out.println("-------------------------------------------------------------------------");
    }

    private static void displayInventory(String[] products, int[][] inventory)
    {
        System.out.println("\n------------------------------Inventory--------------------------------");
        for(int i=0;i<products.length;i++)
        {
            System.out.println(products[i]+" ($"+inventory[i][1]+") : "+inventory[i][0]+" units in stock");
        }
        System.out.println("-------------------------------------------------------------------------");
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
            else if (num>inventory)    //checking if sold>stock
            {
                System.out.println("Warning! Insufficient stock quantity. Enter number in the range (1-"+inventory+")");
            }
        }
        return num;
    }

    private static int priceValidation(Scanner sc, String type)
    {
        int price=-1;
        System.out.println("Enter the "+type+"price : ");
        while(price<0)
        {
            while(!sc.hasNextInt())         //checking if units is integer
            {
                System.out.println("Error! invalid input. Enter a positive integer");
                sc.next();
            }
            price=sc.nextInt();
            if(price<0)   //checking if unit is within range
            {
                System.out.println("Error! invalid input. Enter a non-negative integer");
            }
        }
        return price;
    }

    private static int restockValidation(Scanner sc, int maxRestock)
    {
        int units=-1;
        while (units<1 || units>maxRestock)
        {
            while (!sc.hasNextInt())
            {
                System.out.println("Error! Please enter a valid number (integer).");
                sc.next();
            }
            units = sc.nextInt();
            if (units < 1||units>maxRestock)  //checking if stock quantity exceeds 100
            {
                System.out.println("Error! Number of units must be between 1 and "+maxRestock+" units.");
            }
        }
        return units;
    }

}
