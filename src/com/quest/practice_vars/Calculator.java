package com.quest.practice_vars;

import java.util.Scanner;

public class Calculator
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the starting number : ");
        while (!sc.hasNextDouble())
        {
            System.out.println("Invalid input! Please enter a valid number (double).");
            sc.next();
        }
        double result=sc.nextDouble();
        boolean repeat=true;
        while(repeat)
        {
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Square Root");
            System.out.println("6. Clear current result");
            System.out.println("7. Exit/Continue");
            System.out.println("Enter your choice : ");
            while (!sc.hasNextInt())
            {
                System.out.println("Invalid input! Please enter a valid number.");
                sc.next();
            }
            int choice=sc.nextInt();
            int y=0;
            switch (choice)
            {
                case 1:
                    System.out.println("Enter number to add : ");
                    y=sc.nextInt();
                    result+=y;
                    break;
                case 2:
                    System.out.println("Enter number to subtract : ");
                    y=sc.nextInt();
                    result-=y;
                    break;
                case 3:
                    System.out.println("Enter number to multiply with : ");
                    y=sc.nextInt();
                    result*=y;
                    break;
                case 4:
                    System.out.println("Enter number to divide by : ");
                    y= sc.nextInt();
                    if(y==0)
                    {
                        System.out.println("Error! Enter non-zero number!");
                    }
                    result/=y;
                    break;
                case 5:
                    if(result>0)
                        result=Math.sqrt(result);
                    else
                    {
                        System.out.println("Error! enter positive number!");
                    }
                    break;
                case 6:
                    System.out.println("Clearing result...");
                    result=0;
                    break;
                case 7:
                    System.out.println("Do you want to continue ? (Enter Y/N) : ");
                    char ch=sc.next().charAt(0);
                    if(ch=='N')
                    {
                        repeat = false;
                    }
                    else if(ch=='Y')
                    {
                        System.out.println("Enter number : ");
                        result=sc.nextDouble();
                    }
                    if(ch!='N'||ch!='Y')
                    {
                        System.out.println("Error! Enter only Y/N!");
                        System.out.println("Do you want to continue ? (Enter Y/N) : ");
                        ch=sc.next().charAt(0);
                    }
                    break;
                default: System.out.println("Invalid choice. Try again.");
            }
            System.out.println("Result : "+result);
        }
    }
}
