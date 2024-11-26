package com.quest.programs_practice;

import java.util.Arrays;

public class FindMissingElementArray
{
    public static void main(String[] args)
    {
//        int[] arr={10,20};
        int[] arr={11,5,2,11,11,13};
        System.out.println("original array            : "+Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("sorted array              : "+Arrays.toString(arr));
        int[] temp=new int[arr.length];
        //removing duplicates
        int j=0;
        for(int i=0;i<arr.length;i++)
        {
            if(i==0 || arr[i]!=arr[i-1])
                temp[j++]=arr[i];
        }
        temp = Arrays.copyOf(temp, j);
        System.out.println("after removing duplicates : "+Arrays.toString(temp));
        System.out.print("missing elements in array : ");
        for(int i=0;i<temp.length-1;i++)
        {
            if(temp[i]+1!=temp[i+1] || temp[i]!=0)
            {
                for(int k=temp[i]+1;k<temp[i+1];k++)
                {
                    System.out.print(k+" ");
                }
            }
        }
    }
}





