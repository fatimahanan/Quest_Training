package com.quest.practice_vars;

import java.util.Scanner;

public class DoWhileLoop
{
    public static void main(String[] args)
    {
        int num;
        Scanner sc = new Scanner(System.in);
        do          //loop runs atleast once
        {
            System.out.println("Enter a positive number");
            num=sc.nextInt();
        }while(num<=0);
        System.out.println("You have entered a valid positive number : "+num);
    }
}
