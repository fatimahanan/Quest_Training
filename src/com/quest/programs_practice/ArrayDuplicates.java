package com.quest.programs_practice;

import java.util.ArrayList;

public class ArrayDuplicates
{
    public static void main(String[] args)
    {
        int[] arr={2,3,1,2,9,2,4,3};
        //Arrays.sort(arr);
        ArrayList<Integer> a=new ArrayList<Integer>();
        boolean findDuplicate=false;
        for (int i=0; i<arr.length; i++)
        {
            if(a.contains(arr[i]))
            {
                System.out.println("Duplicate element : "+arr[i]+" at position "+(i+1));
                findDuplicate=true;
            }
            else
                a.add(arr[i]);
        }
        if(!findDuplicate)
            System.out.println("No duplicate element");
    }
}
