package com.quest.java8.ConsumerEg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TransformList
{
    public static void main(String[] args)
    {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));


        Predicate<Integer> toEvenNumber=(num) ->
        {
            return num%2==0;
        };
        System.out.println("\npredicate...");
        final List<Integer> evenNumbers = list.stream().filter(toEvenNumber).toList();
        System.out.println(evenNumbers);


        Consumer<Integer> doubleNum=(num) ->
        {
            System.out.println(num*2);
        };
        System.out.println("\nconsumer...");
        evenNumbers.forEach(doubleNum);


        Supplier<List<Integer>> transformedList = () ->
        {
            List<Integer> doubled=new ArrayList<>();
            evenNumbers.forEach(num->doubled.add(num*2));
            return doubled;
        };
        System.out.println("\nsupplier...");
        List<Integer> doubledList = transformedList.get();
        System.out.println(doubledList);

    }
}
