package com.quest.oops.inheritanceEg2;

public class A extends B
{
    public static void main(String[] args)
    {
        A a=new A();
        a.add(2,3);
    }

    A()
    {
        System.out.println("A class constructor");
    }
    public void add(int a, int b)
    {
        super.add(a,b);
        int sum=a+b;
        System.out.println("A class add method "+sum);
    }
    public void add()
    {
        this.add();
        System.out.println("A Class add method (no arguments)");
    }
    static void add(int a)
    {
        System.out.println("A class static method"+a);
    }
}

