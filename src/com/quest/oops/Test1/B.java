package com.quest.oops.Test1;

public class B
{
    public void add(int a, int b)
    {
        int sum=a+b;
        System.out.println("B class add method : "+sum);
    }

    public void add()
    {
        System.out.println("B class add method (no arguments).");
    }

    static void add(int a)
    {
        System.out.println("B class static method : "+a);
    }
}
