package com.quest.collections.practice.Set;

import java.util.*;

public class ListToSet
{
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(Arrays.asList("banana","apple","orange","banana","mango","apple"));
        System.out.println("list                     : "+list);
        HashSet<String> set = new HashSet<>(list);
        System.out.println("set (removed duplicates) : "+set);

    }
}
