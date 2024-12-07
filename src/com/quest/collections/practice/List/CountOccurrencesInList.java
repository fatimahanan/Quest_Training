package com.quest.collections.practice.List;

import java.util.ArrayList;
import java.util.Arrays;

public class CountOccurrencesInList
{
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>(Arrays.asList(3,2,1,3,4,2,5));
        ArrayList<Integer> countList=new ArrayList<>();
        System.out.println("List : "+list);
        System.out.println("element | count");
        for(int n:list)
        {
            if(!countList.contains(n)) //not already counted
            {
                int count=0;
                for (int num : list)
                {
                    if(num == n)
                    {
                        count++;
                    }
                }
                System.out.println(n+"       | "+count);
                countList.add(n);
            }
        }
    }
}
