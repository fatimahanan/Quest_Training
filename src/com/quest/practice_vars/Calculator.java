package com.quest.practice_vars;

import java.util.Scanner;

public class Calculator
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the starting number : ");
        double result=validateDoubleNum(sc);
        boolean repeat=true;
        while(repeat)
        {
            //operations menu
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
            double y=0.0;
            switch (choice)
            {
                case 1:
                    System.out.println("Enter number to add : ");
                    y=validateDoubleNum(sc);
                    result+=y;
                    break;
                case 2:
                    System.out.println("Enter number to subtract : ");
                    y=validateDoubleNum(sc);
                    result-=y;
                    break;
                case 3:
                    System.out.println("Enter number to multiply with : ");
                    y=validateDoubleNum(sc);
                    result*=y;
                    break;
                case 4:
                    System.out.println("Enter number to divide by : ");
                    y= validateDoubleNum(sc);
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
                        System.out.println("Error! Cannot find square root of negative numbers!");
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
                        System.out.println("Error! Invalid input");
                        System.out.println("Do you want to continue ? (Enter Y/N) : ");
                        ch=sc.next().charAt(0);
                    }
                    break;
                default: System.out.println("Invalid choice. Try again.");
            }
            System.out.println("Result : "+result);
        }
    }
    private static double validateDoubleNum(Scanner sc)
    {
        double y=0.0;
        while (!sc.hasNextDouble())
        {
            System.out.println("Invalid input! Please enter a valid number.");
            sc.next();
        }
        y=sc.nextDouble();
        return y;
    }
    private static int validateIntNum(Scanner sc)
    {
        int y=0;
        while (!sc.hasNextInt())
        {
            System.out.println("Invalid input! Please enter a valid number.");
            sc.next();
        }
        y=sc.nextInt();
        return y;
    }
}
