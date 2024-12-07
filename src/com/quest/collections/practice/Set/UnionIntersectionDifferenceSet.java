package com.quest.collections.practice.Set;

import java.util.Arrays;
import java.util.HashSet;

public class UnionIntersectionDifferenceSet
{
    public static void main(String[] args) {
        HashSet<Integer> hashSet1 = new HashSet<>(Arrays.asList(1,2,3,4,6,8,10));
        HashSet<Integer> hashSet2 = new HashSet<>(Arrays.asList(1,2,3,5,7,9));
        System.out.println("set 1 : "+hashSet1);
        System.out.println("set 2 : "+hashSet2);
        HashSet<Integer> union = new HashSet<>(hashSet1);
        union.addAll(hashSet2);
        System.out.println("union : "+union);
        HashSet<Integer> intersection = new HashSet<>(hashSet1);
        intersection.retainAll(hashSet2);  //retaining elements in both sets
        System.out.println("intersection : "+intersection);
        HashSet<Integer> difference1 = new HashSet<>(hashSet1);
        difference1.removeAll(hashSet2);
        System.out.println("difference (set1-set2) : "+difference1);
        HashSet<Integer> difference2 = new HashSet<>(hashSet2);
        difference2.removeAll(hashSet1);
        System.out.println("difference (set2-set1) : "+difference2);

    }
}
