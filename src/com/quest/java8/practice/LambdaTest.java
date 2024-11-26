package com.quest.java8.practice;

public class LambdaTest
{
    public static void main(String[] args)
    {
        MyFunctionalInterface fi = new MyFunctionalInterfaceImpl();
        fi.perform("input 1");

        MyFunctionalInterface fi2 = new MyFunctionalInterface()
        {
            @Override
            public String perform(String str)
            {
                return "Anonymous perform is called.";
            }
        };

        MyFunctionalInterface fi3 = (s1) -> {
            return "performing"+s1;
        };

        String output=fi3.perform("input2");
    }
}