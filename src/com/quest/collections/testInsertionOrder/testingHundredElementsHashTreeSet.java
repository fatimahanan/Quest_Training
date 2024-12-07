package com.quest.collections.testInsertionOrder;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class testingHundredElementsHashTreeSet
{
    public static void main(String[] args)
    {
        //hash set
        HashSet<Integer> hs=new HashSet<>();
        for(int i=1;i<=100;i++)
        {
            hs.add(i);
        }
        System.out.println("displaying hash set");
        for(int i: hs)
        {
            System.out.println(i);
        }

        //linked hash set
        LinkedHashSet<Integer> lhs=new LinkedHashSet<>();
        for(int i=1;i<=100;i++)
        {
            lhs.add(i);
        }
        System.out.println("\ndisplaying linked hash set");
        for(int i: lhs)
        {
            System.out.println(i);
        }

        //Tree Set
        TreeSet<Integer> ts=new TreeSet<>();
        for(int i=1;i<=100;i++)
        {
            ts.add(i);
        }
        System.out.println("\ndisplaying tree set");
        for(int i: ts)
        {
            System.out.println(i);
        }
    }
}
