package com.quest.exception_handling.practice;

public class StackOverflowEg
{
    public static void causeStackOverflow()
    {
        causeStackOverflow();
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
