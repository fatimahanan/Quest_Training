package com.quest.collections.practice.Map;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Employee
{
    public static void main(String[] args) {
        TreeMap<Integer,String> employee = new TreeMap<>();
        employee.put(1,"John");
        employee.put(2,"Jane");
        employee.put(3,"Dennis");
        employee.put(4,"Bob");
        employee.put(5,"Peter");
        for(Map.Entry<Integer,String> entry : employee.entrySet())
        {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter emp id to search for : ");
        int searchKey=sc.nextInt();
        if(employee.containsKey(searchKey))
        {
            System.out.println("Employee name : "+employee.get(searchKey));
        }
        else
        {
            System.out.println("Employee not found");
        }

    }
}
