package com.quest.logical;

public class Palindrome
{
    public static void main(String[] args)
    {
        String str1="malayalam";
        String str2="hello";
        checkPalindrome(str1);
        checkPalindrome(str2);


    }
    public static void checkPalindrome(String str)
    {
        String rev="";
        for(int i=str.length()-1; i>=0; i--)
        {
            rev=rev+str.charAt(i);
        }
        if(str.equals(rev))
            System.out.println(str+" is a palindrome");
        else
            System.out.println(str+" is not a palindrome");
    }
}
