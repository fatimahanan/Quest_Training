package com.quest.Collections.practice.Map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class FindFreqOfCharMap
{
    public static void main(String[] args)
    {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        String str="hello";
        System.out.println("String : "+str);
        for(char c:str.toLowerCase().toCharArray())
        {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(Map.Entry<Character, Integer> entry:map.entrySet())
        {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
