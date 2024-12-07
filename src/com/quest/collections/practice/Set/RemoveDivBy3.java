package com.quest.collections.practice.Set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class RemoveDivBy3
{
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        System.out.println("set : "+set);
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext())
        {
            if(iterator.next()%3==0)
                iterator.remove();
        }
        System.out.println("updated set : "+set);
    }
}
