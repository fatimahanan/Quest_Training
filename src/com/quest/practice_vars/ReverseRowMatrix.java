package com.quest.practice_vars;

import static java.lang.System.out;

public class ReverseRowMatrix
{
    public static void main(String[] args)
    {
        int[][] arr={{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("Original Matrix : ");
        printArray(arr);
        reverseRow(arr);
        System.out.println("\nTransformed Matrix : ");
        printArray(arr);
    }

    private static void printArray(int[][] arr)
    {
        for(int i=0;i<3;i++)
        {
            for (int j=0;j<3;j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void reverseRow(int[][] arr)
    {
        for(int i=0;i<3;i++)
        {
            int left=0;
            int right=arr.length-1;
            while(left<right)
            {
                int temp=arr[i][left];
                arr[i][left]=arr[i][right];
                arr[i][right]=temp;
                left++;
                right--;
            }
        }
    }
}
