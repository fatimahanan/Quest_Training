package com.quest.collections.practice.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class RemoveEvenNoList
{
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1, 9, 8, 7, 6));
        System.out.println("original list : "+al);
//        for(int i:al)
//        {
//            if(i%2==0)
//                al.remove(i);
//        }
        Iterator<Integer> iterator = al.iterator();
        while (iterator.hasNext())
        {
            if(iterator.next()%2==0)
                iterator.remove();
        }
        System.out.println("list after removing even numbers : "+al);
    }
}
