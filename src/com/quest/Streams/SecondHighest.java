package com.quest.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class SecondHighest
{
    public static void main(String[] args)
    {
        ArrayList<Integer> a=new ArrayList<>(Arrays.asList(5,20,19,2,1));
        Optional<Integer> highest=a.stream().max(Integer::compareTo);
        System.out.println(highest);
        Optional<Integer> secondHighest=a.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        System.out.println(secondHighest);


    }
}
