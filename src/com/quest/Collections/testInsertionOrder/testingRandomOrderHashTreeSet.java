package com.quest.Collections.testInsertionOrder;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class testingRandomOrderHashTreeSet
{
    public static void main(String[] args)
    {
        //hash set
        HashSet<Integer> hs=new HashSet<>();
        hs.add(4);
        hs.add(null);
        hs.add(null);
        hs.add(10);
        hs.add(15);
        hs.add(2);
        hs.add(7);
        hs.add(18);
        hs.add(20);
        hs.add(25);
        hs.add(11);
        hs.add(0);
        System.out.println("displaying hash set");
        for(Integer i: hs)
        {
            System.out.println(i);
        }

        //linked hash set
        LinkedHashSet<Integer> lhs=new LinkedHashSet<>();
        lhs.add(4);
        lhs.add(null);
        lhs.add(null);
        lhs.add(10);
        lhs.add(15);
        lhs.add(2);
        lhs.add(7);
        lhs.add(18);
        lhs.add(20);
        lhs.add(25);
        lhs.add(11);
        lhs.add(0);
        System.out.println("\ndisplaying linked hash set");
        for(Integer i: lhs)
        {
            System.out.println(i);
        }

        //tree set
        TreeSet<Integer> ts=new TreeSet<>();
        ts.add(4);
//        ts.add(null);
        ts.add(10);
        ts.add(15);
        ts.add(2);
        ts.add(7);
        ts.add(18);
        ts.add(20);
        ts.add(25);
        ts.add(11);
        ts.add(0);
        System.out.println("\ndisplaying tree set");
        for(Integer i: ts)
        {
            System.out.println(i);
        }


        HashSet<String> hs2=new HashSet<>();
        hs2.add("grapes");
        hs2.add("pineapple");
        hs2.add("apple");
        hs2.add("custard apple");
        hs2.add("banana");
        hs2.add("orange");

        System.out.println("\ndisplaying hash set");
        for(String s: hs2)
        {
            System.out.println(s);
        }

        LinkedHashSet<String> lhs2=new LinkedHashSet<>();
        lhs2.add("grapes");
        lhs2.add("pineapple");
        lhs2.add("apple");
        lhs2.add("custard apple");
        lhs2.add("banana");
        lhs2.add("orange");

        System.out.println("\ndisplaying linked set");
        for(String s: lhs2)
        {
            System.out.println(s);
        }

        TreeSet<String> ts2=new TreeSet<>();
        ts2.add("grapes");
        ts2.add("pineapple");
        ts2.add("apple");
        ts2.add("custard apple");
        ts2.add("banana");
        ts2.add("banana");
        ts2.add("orange");

        System.out.println("\ndisplaying tree set");
        for(String s: ts2)
        {
            System.out.println(s);
        }

    }
}
