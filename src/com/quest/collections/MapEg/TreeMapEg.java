package com.quest.collections.MapEg;

import java.util.TreeMap;

public class TreeMapEg
{
    public static void main(String[] args)
    {
        TreeMap<Integer,String> tm=new TreeMap<>();
        tm.put(1,"pineapple");
        tm.put(3,"banana");
        tm.put(2,"mango");
        tm.put(4,"apple");
        tm.put(5,"orange");
        tm.put(7,"blueberry");
        tm.put(5,"orange"); //no duplicates

        TreeMapEg.displayAll(tm);

        System.out.println("\nreplacing key '4' ("+tm.replace(4,"pear")+") with 'pear'...");
        TreeMapEg.displayAll(tm);

        System.out.println("\ndoes it contain key '3' ? : "+tm.containsKey(3));
        System.out.println("does it contain value 'mango' ? : "+tm.containsValue("mango"));

        System.out.println("\nkey of last entry : "+tm.lastKey());
        System.out.println("value of last entry : "+tm.lastEntry().getValue());

        System.out.println("\ndeleting first entry : "+tm.pollFirstEntry());
        TreeMapEg.displayAll(tm);

        System.out.println("\nfloor of 6 : "+tm.floorKey(6));
        System.out.println("ceiling of 6 : "+tm.ceilingKey(6));

    }
    private static void displayAll(TreeMap<Integer,String> tm)
    {
        System.out.println("displaying tree map...");
        tm.forEach((k,v)->System.out.println(k+" "+v));
    }
}
