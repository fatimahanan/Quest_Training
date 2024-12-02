package com.quest.exception_handling.practice;

public class StackOverflowEg //error
{
    public static void causeStackOverflow()
    {
        causeStackOverflow();  //recursive
    }
    public static void main(String[] args)
    {
        try
        {
            causeStackOverflow();
        }
        catch(StackOverflowError e)
        {
            System.out.println("Exception has occurred --- ");
            e.printStackTrace();
        }
    }
}
