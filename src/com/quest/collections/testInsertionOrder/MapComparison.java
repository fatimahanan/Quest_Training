package com.quest.collections.testInsertionOrder;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class MapComparison
{
    public static void main(String[] args)
    {
        HashMap<Integer,String> hm=new HashMap<>();
        TreeMap<Integer, String> tm=new TreeMap<>();
        hm.put(1,"apple");
        hm.put(3,"orange");
        hm.put(2,"banana");
        hm.put(5,"grape");
        hm.put(4,"mango");
        hm.put(6,null);
        hm.put(7,null);
        hm.put(null,"pineapple");
        hm.put(null,null);
        hm.put(null,"tomato");


        tm.put(1,"apple");
        tm.put(3,"orange");
        tm.put(2,"banana");
        tm.put(5,"grape");
        tm.put(4,"mango");
        tm.put(6,null);
        tm.put(7,null);
//        tm.put(null,"pineapple"); //cannot take null as key

        System.out.println("\ndisplaying hashmap");
        hm.forEach((k,v)-> System.out.println(k+" "+v));
        System.out.println("\ndisplaying tree map");
        tm.forEach((k,v)-> System.out.println(k+" "+v));

        HashMap<String,String> hm2=new HashMap<>();
        hm2.put("science","ken");
        hm2.put("maths","john");
        hm2.put("english","angela");
        hm2.put("education","george");
        System.out.println("\ndisplaying hashmap");
        hm2.forEach((k,v)-> System.out.println(k+" : "+v));

        LinkedHashMap<String,String> lhm=new LinkedHashMap<>();
        lhm.put("science","ken");
        lhm.put("maths","john");
        lhm.put("english","angela");
        lhm.put("education","george");
        System.out.println("\ndisplaying linkedhashmap");
        lhm.forEach((k,v)-> System.out.println(k+" : "+v));

        TreeMap<String,String> tm2=new TreeMap<>();
        tm2.put("science","ken");
        tm2.put("maths","john");
        tm2.put("english","angela");
        tm2.put("education","george");
        System.out.println("\ndisplaying treemap");
        tm2.forEach((k,v)-> System.out.println(k+" : "+v));



    }

}
