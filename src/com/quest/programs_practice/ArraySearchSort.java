package com.quest.programs_practice;

import java.util.Arrays;
import java.util.Scanner;

public class ArraySearchSort
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements of array");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the search element");
        int searchElement=sc.nextInt();
        int index=hasSearchElement(arr,searchElement);
        if(index==-1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at index "+index);
        System.out.println("\nSorting the array...");
        int[] sortedArr=printSortedArray(arr);
        System.out.println("The sorted array is :"+ Arrays.toString(sortedArr));
    }

    private static int hasSearchElement(int[] arr,int searchElement)
    {
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==searchElement)
            {
                return i+1;
            }
        }
        return -1;
    }
    private static int[] printSortedArray(int[] arr)
    {
        int n=arr.length;
        boolean swapped=false;
        for (int i = 0; i <n-1; i++)
        {
            for (int j=0; j<n-1-i; j++)
            {
                if (arr[j]>arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)  //if already sorted
            {
                break;
            }
        }
        return arr;
    }
}
