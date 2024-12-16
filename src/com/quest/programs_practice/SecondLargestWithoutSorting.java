package com.quest.practical;

import java.util.ArrayList;
import java.util.Arrays;

public class secondLargest
{
    public static void main(String[] args)
    {
//        [3 7 6 10 1 23]
        ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(3,7,6,10,1,23));
        int max=0;
        int secondLargest=0;
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i)>max)
            {
                secondLargest=max;
                max = arr.get(i);
            }
            else if(arr.get(i)>secondLargest)
                secondLargest= arr.get(i);
        }
        System.out.println(max);
        System.out.println(secondLargest);

    }
}
