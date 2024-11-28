package com.quest.Collections.MapEg;

import java.util.HashMap;
import java.util.Map;

public class HashMapEg
{
    public static void main(String[] args)
    {
        HashMap<Integer, String> hm=new HashMap<>();
        hm.put(1, "apple");
        hm.put(3, "orange");
        hm.put(2, "pear");
        hm.put(4, "carrot");
        hm.put(6, "dates");
        hm.put(5, "banana");
        for(String s: hm.values())
        {
            System.out.println(s);
        }
        for(int i: hm.keySet())
        {
            System.out.println(i);
        }
        System.out.println("displaying...");
        for(Map.Entry<Integer,String> e : hm.entrySet())
        {
            System.out.println(e.getKey()+" : "+e.getValue());
        }

        System.out.println("\ngetting entry using key 5 : "+hm.get(5));
        System.out.println("removing entry using key 5 : "+hm.remove(5));

        hm.put(1,"mango");
        hm.put(5,"kiwi");
        System.out.println("displaying..");
        for(Map.Entry<Integer,String> e : hm.entrySet())
        {
            System.out.println(e.getKey()+" : "+e.getValue());
        }

        System.out.println("\ndoes it contain key '5' : "+hm.containsKey(5));
        System.out.println("does it contain value 'apple' : "+hm.containsValue("apple"));
        System.out.println("\ndoes it contain value 'mango' : "+hm.containsValue("mango"));
    }
}
