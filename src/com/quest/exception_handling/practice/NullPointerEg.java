package com.quest.exception_handling.practice;

public class NullPointerEg //unchecked exception
{
    public static void main(String[] args)
    {
        String str=null;
        try
        {
            System.out.println(str.length()); //null pointer exception
        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
            System.out.println("Exception caught\n"+e.getMessage());
        }
    }
}
