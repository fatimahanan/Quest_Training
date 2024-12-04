package com.quest.programs_practice.questionSet;

import java.util.Scanner;

public class SwapElements
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the length of array : ");
        int n=sc.nextInt();
        int[] a=new int[n];
        System.out.println("Enter the elements of array : ");
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        System.out.println("Enter the index1 of element to be swapped (1-"+n+") : ");
        int x=sc.nextInt();
        System.out.println("Enter the index2 of element to be swapped (1-"+n+") : ");
        int y=sc.nextInt();
        System.out.println("\nOriginal array : ");
        SwapElements.displayArray(a);
        int temp=a[x-1];
        a[x-1]=a[y-1];
        a[y-1]=temp;
        System.out.println("\nArray after swapping :");
        SwapElements.displayArray(a);
    }
    public static void displayArray(int[] arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}
