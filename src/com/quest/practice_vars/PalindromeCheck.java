package com.quest.practice_vars;

import java.util.Scanner;

public class PalindromeCheck
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string:");
        String str=sc.nextLine();
        if(str==null)    // include test cases, nextLine() does not return null
        {
            System.out.println("Invalid! String is null");
            return;
        }
        /*int start=0;
        int end=str.length()-1;
        while(start<end)
        {
            if(str.charAt(start)!=str.charAt(end))
            {
                System.out.println("Not a palindrome");
                return;
            }
            start++;
            end--;
        }
        System.out.println("Palindrome");
         */
        StringBuilder s=new StringBuilder(str);
        StringBuilder rev=new StringBuilder(s.reverse());
        String reverseStr=rev.toString();
        if(str.equals(reverseStr))
            System.out.println("String is a palindrome");
        else
            System.out.println("String is not a palindrome");
    }
}
