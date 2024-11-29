package com.quest.Collections.SetEg;

import java.util.ArrayList;
import java.util.HashSet;

public class HashSetEg
{
    public static void main(String[] args)
    {
        HashSet<Integer> hs = new HashSet<>();
        hs.add(1);
//        hs.add(null);
        hs.add(3);
        hs.add(5);
        hs.add(4);
        hs.add(4);
        System.out.println("\ndisplaying hashSet...");
        for(int i : hs)
            System.out.println(i);

//        ArrayList<Integer> al = new ArrayList<>();
//        al.add(1);
//        al.add(null);
//        al.add(3);
//        al.add(2);
//        al.add(4);
//        System.out.println("\ndisplaying ArrayList...");
//        for(int i : al)
//            System.out.println(i);

        System.out.println("\nsize : "+hs.size());
        System.out.println("\nis the hashset empty? : "+hs.isEmpty());
        System.out.println("\ndoes the hashset contain null ? : "+hs.contains(null));
        System.out.println("does the hashset contain 3 ? : "+hs.contains(3));
        hs.remove(3);
        System.out.println("\nremoving 3...");
        System.out.println("\ndisplaying hashSet...");
        for(int i : hs)
            System.out.println(i);
        hs.clear();
        System.out.println("\nclearing...");
        System.out.println("size : "+hs.size());

    }

}
