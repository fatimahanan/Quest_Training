package com.quest.practice_vars;

import java.util.Scanner;

public class StarPattern
{
    public static void main(String[] args)
    {
        System.out.println("Enter number of rows : ");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=i;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
