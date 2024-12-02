package com.quest.StringClasses;

public class Memory
{
    public static void main(String[] args)
    {
        String s1="hello";
        String s2="hello";
        String s3=new String("hello");
        String s4=new String("hello");
        System.out.println("literals (comparing s1 'hello' and s2 'hello')....");
        check(s1,s2);
        System.out.println("\n*****************\n");
        System.out.println("with new keyword objects (comparing s3 'hello' and s3 'hello')");
        check(s3,s4);
        System.out.println("\n*****************\n");
        System.out.println("assigned(from s4) s5 'hello' and object s4 'hello'....");
        String s5=s4;
        check(s3,s5);
        int i1=1;
        int i2=1;
        System.out.println("\n*****************\n");
        System.out.println("comparing integers 1 and 1");
        check1(i1,i2);
        System.out.println("\n*****************\n");
        String s6="hello world";
        System.out.println("comparing (s6 'hello world' contains s1 'hello')....");
        check3(s6,s1);
//        System.out.println(s1.hashCode());
//        System.out.println(s2.hashCode());
    }

    public static void check(String s1, String s2)
    {
        System.out.println("==");
        if(s1==s2)
        {
            System.out.println(true);
        }
        else
        {
            System.out.println(false);
        }
        System.out.println("\nequals method");
        if(s1.equals(s2))
        {
            System.out.println(true);
        }
        else
        {
            System.out.println(false);
        }
    }

    public static void check1(int i1, int i2) {
        System.out.println("==");
        if (i1 == i2) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    public static void check3(String s1, String s2)
    {
        System.out.println("equals method");
        if(s1.equals(s2))
        {
            System.out.println(true);
        }
        else
        {
            System.out.println(false);
        }
        System.out.println("\ncontains method");
        if(s1.contains(s2))
        {
            System.out.println(true);
        }
        else
        {
            System.out.println(false);
        }
    }
}
