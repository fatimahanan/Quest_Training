package com.quest.programs_practice;

import java.util.Arrays;

public class CountPairs
{
    public static void main(String[] args)
    {
        int[] arr={10,20,10,10,30,20,50,40,40,30,30,10};
        Arrays.sort(arr);
        int count=1;
        int pair=0;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]==arr[i-1])
                count++;
            else
            {
                if(count>=2)
                {
                    int pairs = count / 2;
                    System.out.println(arr[i - 1]+" - "+pairs+" pairs.");
                }
                count=1;
            }
        }
        if(count>=2)
        {
            int pairs = count / 2;
            System.out.println(arr[arr.length-1]+" - "+pairs+" pairs.");
        }
        else
        {
            System.out.println(arr[arr.length-1]+" - 0 pairs.");
        }
    }
}
