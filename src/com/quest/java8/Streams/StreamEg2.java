package com.quest.java8.Streams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamEg2
{
    public static void main(String[] args)
    {
        //converting list to stream: sort and convert to upper case, then filter with names that start with c
        ArrayList<String> names=new ArrayList<>(Arrays.asList("russell","charles","carlos","daniel"));
        List<String> uppercaseSorted=names.stream()
                .sorted()
                .map(String::toUpperCase)
                .filter(s->s.startsWith("C"))
                .collect(Collectors.toList());
        System.out.println(uppercaseSorted);

        //filter number list of even numbers in reverse order
        ArrayList<Integer> num=new ArrayList<>(Arrays.asList(9,1,4,2,3,6,5,8,7));
        List<Integer> sortedEven=num.stream()
                .filter(n->n%2==0)
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println(sortedEven);

        //find the sum
        int sum=num.stream()
                .reduce(0,(a,b)->a+b);
        System.out.println("sum : "+sum);

        //find max
        Optional<Integer> max=num.stream()
                .max(Integer::compareTo);
        System.out.print("max : ");
        max.ifPresent(System.out::print);

        //group by first letter
        Map<Character,List<String>> groupedByFirstLetter=names.stream()
                .collect(Collectors.groupingBy(c->c.charAt(0)));
        System.out.println("\ngrouped by first letter : "+groupedByFirstLetter);

        //group by length of name
        Map<Integer,List<String>> groupedByLength=names.stream()
                .collect(Collectors.groupingBy(s->s.length()));
        System.out.println("Grouped by length : "+groupedByLength);

        //name length map
        Map<String,Integer> nameLengthMap=names.stream()
                .collect(Collectors.toMap(s->s,String::length));
        System.out.println("Name length map : "+nameLengthMap);


        //convert stream to array
        String[] nameArray=names.stream()
                .toArray(String[]::new);
        System.out.println("string array : "+Arrays.toString(nameArray));

    }

}
