package com.quest.collections.practice.Map;

import java.util.Map;
import java.util.TreeMap;

public class SortByKeyMap
{
    public static void main(String[] args) {
        TreeMap<String,Integer> map = new TreeMap<>();
        map.put("B", 1);
        map.put("C", 2);
        map.put("A", 3);
        map.put("D", 4);
        for(Map.Entry<String,Integer> entry : map.entrySet())
        {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
