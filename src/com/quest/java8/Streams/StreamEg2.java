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
                .filter(s->s.startsWith("c"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(uppercaseSorted);

        //filter number list of even numbers in reverse order
        ArrayList<Integer> num=new ArrayList<>(Arrays.asList(3,1,2,4)); //
        List<Integer> sortedEven=num.stream()
                .filter(n->n%2==0)
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println(sortedEven);

        //find the sum
        int sum= num.stream()
                .reduce(0,(a,b)->a+b);
        System.out.println("sum : "+sum);

        //find avg
        OptionalDouble avg=num.stream()
                .mapToInt(Integer::intValue)
                .average();
        if(avg.isPresent())
        {
            System.out.println("average : "+avg.getAsDouble());
        }
//        double avg=num.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        double avg1=num.stream()
                .collect(Collectors.averagingInt(Integer::intValue));
        System.out.println("average 1 : "+avg1);


        //find count
        long count=num.stream().count();
        System.out.println("count : "+count);

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
                .collect(Collectors.groupingBy(String::length));
        System.out.println("Grouped by length : "+groupedByLength);

        //name length map
        Map<String,Integer> nameLengthMap=names.stream()
                .collect(Collectors.toMap(s->s,s->s.length()));
        System.out.println("Name length map : "+nameLengthMap);


        //convert stream to array
        String[] nameArray=names.stream()
                .toArray(String[]::new);
        System.out.println("string array : "+Arrays.toString(nameArray));

        //concatenate
        String concatenated=names.stream()
                .collect(Collectors.joining(" ","\'","\'"));
        System.out.println("concatenated string : "+concatenated);
    }

}
