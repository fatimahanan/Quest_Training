package com.quest.java8.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamEg2
{
    public static void main(String[] args)
    {
        ArrayList<String> names=new ArrayList<>(Arrays.asList("russell","charles","carlos","daniel"));

        List<String> uppercaseSorted=names.stream()
                .sorted()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(uppercaseSorted);


    }

}
