package com.quest.Collections.SetEg;

import java.util.TreeSet;

public class TreeSetEg  //no null allowed
{
    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<Integer>();
        ts.add(1);
        ts.add(2);
        ts.add(5);
        ts.add(3);
        System.out.println("\ndisplaying...");
        for(int i : ts)
        {
            System.out.println(i);
        }
        System.out.println("\nfirst element : "+ts.first());
        System.out.println("last element : "+ts.last());
        System.out.println("\ndescending set : "+ts.descendingSet());
        System.out.println("\nfloor : "+ts.floor(4)); //largest number equal to or before the parameter
        System.out.println("\nheadSet: "+ts.headSet(3)); //prints values until before the parameter. if true, then returns inclusive of that number
        System.out.println("\npollFirst:  "+ts.pollFirst()); //deletes
        System.out.println("\ndisplaying...");
        for(int i : ts)
        {
            System.out.println(i);
        }
        System.out.println(ts.remove(3));
        System.out.println("\ndisplaying...");
        for(int i : ts)
        {
            System.out.println(i);
        }


    }
}
