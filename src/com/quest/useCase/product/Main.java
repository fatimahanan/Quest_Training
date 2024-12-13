package com.quest.useCase.product;

import java.util.*;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args) {
        Product p1=new Product(1,"laptop",30000,4);
        Product p2=new Product(2,"mouse",800,10);
        Product p3=new Product(3,"wire",100,20);
        Product p4=new Product(4,"power bank",2500,5);
        Product p5=new Product(5,"multiplug",400,8);
        ArrayList<Product> productList=new ArrayList<>(Arrays.asList(p1,p2,p3,p4,p5));
        //total value
        double totalValue=productList.stream()
                .mapToDouble(p->p.getPrice()*p.getQuantity())
                .sum();
        System.out.println("total value : "+totalValue);

        //most expensive top3
        List<String> expensiveProducts = productList.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .skip(productList.size()-3)
                .map(Product::getName)
                .toList();

        System.out.println("\nmost expensive : \n"+expensiveProducts);

        Map<String,Double> namePriceMap=productList.stream()
                .collect(Collectors.toMap(Product::getName,Product::getPrice));

        System.out.println("\nname price map : \n"+namePriceMap);
    }
}
