package com.quest.collections.MapEg;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapEg
{
    public static void main(String[] args)
    {
        LinkedHashMap<Integer, String> lhm = new LinkedHashMap<>();
        lhm.put(1, "hamster");
        lhm.put(3, "dog");
        lhm.put(2, "cat");
        lhm.put(4, "fish");
        lhm.put(5, "cow");
        lhm.put(null,"buffalo");
        lhm.put(null,"pig");
        lhm.put(6,null);
        lhm.put(7,null);
        LinkedHashMapEg.displayAll(lhm);

        System.out.println("\nget entry by key '3' : "+lhm.get(3));
        System.out.println("\nreplacing... entry of '5' ("+lhm.replace(5,"goat") +") with 'goat'");
        LinkedHashMapEg.displayAll(lhm);

        System.out.println("\ndoes it contain value 'cat' ? : "+lhm.containsValue("cat"));
        System.out.println("does it contain key 6 ? : "+lhm.containsKey(6));

        System.out.println("\nremoving 5th index : "+lhm.remove(5));
        LinkedHashMapEg.displayAll(lhm);

        System.out.println("\nsize : "+lhm.size());
        System.out.println("\ntrying to add duplicates...");
        lhm.put(5,"goat");
        lhm.put(5,"goat");
        LinkedHashMapEg.displayAll(lhm);

        lhm.clear();
        System.out.println("\nclearing...");
        LinkedHashMapEg.displayAll(lhm);

    }
    private static void displayAll(LinkedHashMap<Integer, String> lhm)
    {
        System.out.println("displaying linked hash set...");
        for(Map.Entry<Integer, String> entry : lhm.entrySet())
        {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
