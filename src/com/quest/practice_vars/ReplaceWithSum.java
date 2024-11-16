package com.quest.practice_vars;

import java.util.Arrays;

public class ReplaceWithSum
{
    public static void main(String[] args)
    {
        int[] arr={2, 4, 5, 7, 8};
        int sum=0;
        for(int n : arr)
            sum+=n;
        for(int i=0; i<arr.length; i++)
        {
            arr[i]=sum-arr[i];
        }
        System.out.println(Arrays.toString(arr));
    }
}
