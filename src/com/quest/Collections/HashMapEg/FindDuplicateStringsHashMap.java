package com.quest.Collections.HashMapEg;

import java.util.HashMap;
import java.util.Map;

public class FindDuplicateStringsHashMap
{
    public static void main(String[] args) {
        String[] arr={"java","python","kotlin","java","c++","python","kotlin"};
        HashMap<String,Integer> map=new HashMap<>();
        for(String lang:arr)
        {
            map.put(lang, map.getOrDefault(lang,0)+1);
        }
        for(Map.Entry<String,Integer> entry:map.entrySet())
        {
            if(entry.getValue()>1)
                System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
