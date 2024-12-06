package com.quest.java8.ConsumerEg;

import java.util.function.Consumer;

public class StudentNameCapitalized
{
    public static void main(String[] args)
    {
        String sName="hanan";
        Consumer<String> printCaps= (name) ->
        {
            System.out.println(name.toUpperCase());
        };
        printCaps.accept(sName);
    }
}
