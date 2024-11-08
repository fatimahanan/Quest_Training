package com.quest.practice_vars;

import java.util.Scanner;

public class PalindromeNum
{
    public static void main(String[] args)
    {
        System.out.println("Enter number : ");
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int original=num;
        int rev=0;
        while(num!=0)
        {
            int digit=num%10;
            rev=rev*10+digit;
            num=num/10;
        }
        if(original==rev)
            System.out.println(original+" is a palindrome");
        else
            System.out.println(original+" is not a palindrome");
    }
}
