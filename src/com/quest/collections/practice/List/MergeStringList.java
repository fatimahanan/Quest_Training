package com.quest.collections.practice.List;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeStringList
{
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList("apple","mango","banana"));
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("tomato","mango","papaya","banana"));
        System.out.println("list 1 : "+list1);
        System.out.println("list 2 : "+list2);
        ArrayList<String> merged = new ArrayList<>();
        merged.addAll(list1);
        for(String s : list2)
        {
            if(!merged.contains(s))
            {
                merged.add(s);
            }
        }
        System.out.println("merged list : "+merged);


    }
}
