package com.quest.Collections.practice.Set;

import java.util.Arrays;
import java.util.HashSet;

public class CheckContainsAllSet
{
    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1,2,3,4,5,6));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(4,5,6));
        System.out.println("set 1 : "+set1);
        System.out.println("set 2 : "+set2);
        System.out.println("does set1 contain set2 ? : "+set1.containsAll(set2));
    }
}
