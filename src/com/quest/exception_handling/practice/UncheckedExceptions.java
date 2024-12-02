package com.quest.exception_handling.practice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UncheckedExceptions
{
    public static void main(String[] args) throws ArithmeticException, ArrayIndexOutOfBoundsException, NullPointerException, InputMismatchException
    {
        Scanner sc=new Scanner(System.in);

        //first
        try
        {
            System.out.println("***Enter two numbers to divide (n1/n2)***");
            System.out.println("Enter n1 : ");
            int n1 = sc.nextInt();
            System.out.println("Enter n2 : ");
            int n2 = sc.nextInt();
            int result = n1 / n2;
            System.out.println("Result = " + result);
        }
        catch(ArithmeticException e)
        {
            e.printStackTrace();
            System.out.println("Arithmetic Exception....cannot divide by zero\n");
        }
        catch (InputMismatchException e)
        {
            e.printStackTrace();
            System.out.println("InputMismatchException....invalid input, enter integer\n");
        }
        finally
        {
            System.out.println("Exception handling complete\n");
        }

        //second

        try
        {
            System.out.println("\n***Array***");
//        int[] a=null;
            int[] a={1,2,3,4,5};
            for(int i=0;i<a.length;i++)
            {
                System.out.print(a[i]+ " ");
            }
            System.out.println("Enter index to print element for : ");
            int index=sc.nextInt();
            System.out.println("Element at index "+index+" is : "+a[index]);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            e.printStackTrace();
            System.out.println("ArrayIndexOutOfBoundsException....element not accessible\n");
        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
            System.out.println("NullPointerException....null value accessed\n");
        }
        catch (InputMismatchException e)
        {
            e.printStackTrace();
            System.out.println("InputMismatchException....inavlid input, enter integer\n");
        }
        finally
        {
            System.out.println("Exception handling complete\n");
        }
    }
}
