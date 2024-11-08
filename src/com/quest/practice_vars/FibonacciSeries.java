package com.quest.practice_vars;

import java.util.Scanner;

public class FibonacciSeries
{
    public static void main(String[] args)
    {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements : ");
        n=sc.nextInt();
        if(n<0) {
            System.out.println("Invalid input, enter positive number.");
            return;
        }
        int first=0;
        int second=1;
        System.out.println("Fibonacci series upto "+n+" terms");
        for(int i=1;i<=n;i++)
        {
            System.out.println(first+" ");
            int third=first+second;
            first=second;
            second=third;
        }
    }
}
