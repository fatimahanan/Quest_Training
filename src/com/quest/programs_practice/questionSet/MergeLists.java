package com.quest.programs_practice.questionSet;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeLists
{
    public static void main(String[] args)
    {
        ArrayList<Integer> list1=new ArrayList<>(Arrays.asList(1,2,3));
        ArrayList<Integer> list2=new ArrayList<>(Arrays.asList(4,5,6));
        ArrayList<Integer> mergedList=new ArrayList<>(list1);
        mergedList.addAll(list2);
        System.out.println("list 1      : "+list1);
        System.out.println("list 2      : "+list2);
        System.out.println("merged list : "+mergedList);
    }
}
