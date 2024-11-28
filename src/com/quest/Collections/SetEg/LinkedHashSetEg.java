package com.quest.Collections.SetEg;

import java.util.LinkedHashSet;

public class LinkedHashSetEg //cannot have null, or atmost 1 (if string/object)
{
    public static void main(String[] args) {
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("apple");
        lhs.add("banana");
        lhs.add(null);
        lhs.add(null);
        lhs.add("orange");
        lhs.add("mango");
        System.out.println("Displaying linked hash set : ");
        for(String s : lhs)
            System.out.println(s);
        System.out.println("\ndoes linked hash set contain 'hi' ? : "+lhs.contains("hi"));
        System.out.println("does linked hash set contain 'apple' ? : "+lhs.contains("apple"));
        System.out.println("\nsize of linked hashset : "+lhs.size());
        System.out.println("\nremoving apple : "+lhs.remove("apple"));
        System.out.println("Displaying linked hash set : ");
        for(String s : lhs)
            System.out.println(s);
        System.out.println("\nclearing...");
        lhs.clear();
        System.out.println("linked hash size : "+lhs.size());

        LinkedHashSet<Integer> intLhs = new LinkedHashSet<>();
        intLhs.add(2);
        intLhs.add(3);
        intLhs.add(1);
        intLhs.add(2);
        intLhs.add(4);
        System.out.println("Displaying linked hash set : ");
        for(int s : intLhs)
            System.out.println(s);
    }
}
