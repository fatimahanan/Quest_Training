package com.quest.programs_practice.questionSet;

import java.util.Arrays;
import java.util.Scanner;

public class FindSecondLargest //element in the array
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the length of array");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements of array");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        int largest=arr[n-1];
        int secondLargest=-1;
        for(int i=n-2;i>=0;i--)
        {
            if(arr[i]<largest)
            {
                secondLargest=arr[i];
                break;
            }
        }
        System.out.println("second largest : "+secondLargest);
    }
}
