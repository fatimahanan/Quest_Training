package com.quest.practice_vars;

public class ArraysExample
{
    public static void main(String[] args)
    {
        int[] arr = new int[10];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=i+1;
        }
        for(int x: arr)
        {
            System.out.println(x);
        }
        System.out.println("PRINTING 2-D ARRAY ");
        int[][] arr2 = new int[10][10];
        for(int i=0;i<arr2.length;i++)
        {
            for(int j=0;j<arr2[i].length;j++)
            {
                arr2[i][j]=j+1;
            }
        }
        for(int[] arrayEg: arr2)
        {
            System.out.println("--");
            for(int x: arrayEg)
                System.out.println(x);
        }
    }
}
