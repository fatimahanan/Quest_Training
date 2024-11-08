package com.quest.practice_vars;

import java.util.Scanner;

public class SumOfDigits
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int num=sc.nextInt();
        int sum=0;
        num=Math.abs(num);
        while(num!=0)
        {
            sum+=num%10;
            num=num/10;
        }
        System.out.println("Sum of digits = "+sum);
    }
}
