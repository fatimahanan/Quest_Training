package com.quest.Collections.practice.Set;

import java.util.HashSet;

public class FirstDuplicateIntegerSeqSet
{
    public static void main(String[] args) {
        HashSet<Integer> hs=new HashSet();
        int[] seq={1,7,2,7,1,3,5};
        for (int i:seq)
        {
            if(hs.contains(i))
            {
                System.out.println("first duplicate : "+i);
                return;
            }
            hs.add(i);
        }
        System.out.println("no duplicates");
    }
}
