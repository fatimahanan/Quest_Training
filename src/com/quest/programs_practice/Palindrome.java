package com.quest.programs_practice;

public class Palindrome
{
    public static void main(String[] args)
    {
        String str="";
        String rev="";
        if(str.isEmpty())
        {
            System.out.println("The string is null");
        }
        else
        {
            for(int i=str.length()-1;i>=0;i--)
            {
                rev=rev+str.charAt(i);
            }
            if(str.equals(rev))
            {
                System.out.println(str+" is a palindrome");
            }
            else
            {
                System.out.println(str+" is not a palindrome");
            }
        }
    }
}
