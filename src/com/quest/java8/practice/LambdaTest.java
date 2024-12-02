package com.quest.java8.practice;

public class LambdaTest
{
    public static void main(String[] args)
    {
        MyFunctionalInterfaceImpl fi = new MyFunctionalInterfaceImpl();
        System.out.println(fi.perform("input 1"));

        MyFunctionalInterface fi2 = new MyFunctionalInterface()
        {
            @Override
            public String perform(String str)
            {
                return "Anonymous perform is called.";
            }
        };

        System.out.println(fi2.perform("input 2"));

        MyFunctionalInterface fi3 = (s1) -> {
            return "performing"+s1;
        };

        String output=fi3.perform("input2");
        System.out.println(output);
    }
}