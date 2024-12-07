package com.quest.collections.practice.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Products
{
    public static void main(String[] args) {
        HashMap<String,Integer> prod=new HashMap<>();
//        prod.put("Apple",50);
//        prod.put("Banana",30);
//        prod.put("Orange",20);
//        prod.put("Grapes",10);
//        prod.put("Pineapple",20);
//        prod.put("Watermelon",40);
        System.out.println("Enter no. of products : ");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println("Enter product details : ");
        for (int i=0;i<n;i++)
        {
            System.out.println("Enter product "+(i+1)+" : ");
            String name=sc.next();
            System.out.println("Enter price : ");
            Integer price=sc.nextInt();
            sc.nextLine();
            prod.put(name,price);
        }
        for(Map.Entry<String,Integer> entry:prod.entrySet())
        {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
        System.out.println("\nEnter product name to update price for : ");
        String updateName=sc.nextLine();
        if(prod.containsKey(updateName))
        {
            System.out.println("Enter price : ");
            int newPrice=sc.nextInt();
            prod.put(updateName,newPrice);
            for(Map.Entry<String,Integer> entry:prod.entrySet())
            {
                System.out.println(entry.getKey()+" : "+entry.getValue());
            }
        }
        else
        {
            System.out.println("Product does not exist");
        }
        System.out.println("\nFinding highest priced fruit...");
        int highestPrice=Integer.MIN_VALUE;
        String highestPricedFruit=null;
        for(Map.Entry<String,Integer> entry:prod.entrySet())
        {
            if(entry.getValue()>highestPrice)
            {
                highestPrice = entry.getValue();
                highestPricedFruit=entry.getKey();
            }
        }
        System.out.println(highestPricedFruit+" -> "+highestPrice);

    }
}
