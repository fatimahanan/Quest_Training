package com.quest.programs_practice;

public class TwoDimensionalArray
{
    public static void main(String[] args)
    {
        int[][] arr={{1,2,3},{4,5,6},{7,8,9}};
        for(int i= arr.length-1;i>=0;i--) // reverses row order
        {
            for(int j=arr[i].length-1;j>=0;j--) //reverses column order
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }
}
