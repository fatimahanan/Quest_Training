package com.quest.Collections.practice.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class FindSecondLargestIntegerList
{
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(4,5,1,3,9,8,2));
        System.out.println("list : "+list);
        int highest=Integer.MIN_VALUE;
        int secondHighest=Integer.MIN_VALUE;
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext())
        {
            int num = iterator.next();
            if(num>highest)
            {
                secondHighest = highest;
                highest = num;
            }
            else if(num>secondHighest && num<highest)
            {
                secondHighest = num;
                highest=num;
            }
        }
        if(secondHighest==Integer.MIN_VALUE)
        {
            System.out.println("no secondHighest");
        }
        else
            System.out.println("second highest : "+secondHighest);
    }
}
