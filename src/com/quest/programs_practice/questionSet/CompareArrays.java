package com.quest.programs_practice.questionSet;

import java.util.Scanner;

public class CompareArrays
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of array 1 : ");
        int s1=sc.nextInt();
        int[] arr1=new int[s1];
        System.out.println("Enter the array 1: ");
        for(int i=0;i<s1;i++)
        {
            arr1[i]=sc.nextInt();
        }
        System.out.println("Enter size of array 2 : ");
        int s2=sc.nextInt();
        int[] arr2=new int[s2];
        System.out.println("Enter the array 2: ");
        for(int i=0;i<s2;i++)
        {
            arr2[i]=sc.nextInt();
        }
        if(arr1.length!=arr2.length)
        {
            System.out.println("The arrays are not the same");
        }
        else
        {
            boolean same=false;
            for(int i=0;i<arr1.length;i++)
            {
                if(arr1[i]==arr2[i])
                    same=true;
                else
                {
                    System.out.println("The arrays are not the same");
                    same=false;
                    break;
                }
            }
            if(same)
                System.out.println("The arrays are the same");
        }
    }

}
