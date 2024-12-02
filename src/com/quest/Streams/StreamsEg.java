package com.quest.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsEg
{
    public static void main(String[] args)
    {
        ArrayList<Integer> al = new ArrayList<>();
        al.addAll(Arrays.asList(6, 2, 2, 3, 4, 5, 6, 7, 8, 9));
        System.out.println("find first : "+al.stream().findFirst().get());
        System.out.println("find any : "+al.stream().findAny().get());
        System.out.println("find max : "+al.stream().max(Integer::compare).get());
        System.out.println("find min : "+al.stream().min(Integer::compare).get());
        System.out.println("count : "+ al.size());
        System.out.println("distinct count : "+al.stream().distinct().count());
        System.out.println("sum : "+al.stream().reduce(0,Integer::sum)); //sum using streams
        List<Integer> evenNumber=al.stream().filter(i -> i%2==0).toList();
        System.out.println("evenNumber : "+evenNumber);
        List<Integer> twiceNumber=al.stream().map(i -> i*2).toList();
        System.out.println("twiceNumber : "+twiceNumber);
        int SumOfTwiceTheNumber=al.stream().map(i -> i*2).reduce(0,Integer::sum);
        System.out.println("SumOfTwiceTheNumber : "+SumOfTwiceTheNumber);
        int min=al.stream().map(i->i*2).min(Integer::compare).get();
        System.out.println("min : "+min);
        int max=al.stream().map(i->i*2).max(Integer::compare).get();
        System.out.println("max : "+max);
    }
}
