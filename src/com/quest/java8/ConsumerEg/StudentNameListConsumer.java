package com.quest.java8.ConsumerEg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class StudentNameListConsumer
{
    public static void main(String[] args)
    {
        ArrayList<String> nameList = new ArrayList<>(Arrays.asList("hanan","lola","noah","thomas"));

        Consumer<String> printCapsLength= (name) ->
        {
            System.out.println(name.toUpperCase());
            System.out.println(name.length());
        };
        System.out.println("consumer...");
        nameList.forEach(printCapsLength);


        Predicate<String> checkLength=(name) ->
        {
            return name.length()>4;
        };
        System.out.println("\npredicate...");
        nameList.forEach( (name) ->
        {
            if(checkLength.test(name))
                printCapsLength.accept(name);
        });

        Supplier<Integer> lengthFirst=() ->
        {
            return nameList.get(1).length();
        };
        System.out.println("\nsupplier...");
        int lengthOfFirst=lengthFirst.get();
        System.out.println("length of second name : "+lengthOfFirst);
    }
}
