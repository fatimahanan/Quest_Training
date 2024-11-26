package com.quest.java8.practice;

public class MyFunctionalInterfaceImpl implements MyFunctionalInterface
{
    @Override
    public String perform(String str)
    {
        return "performing inside fi : "+str;
    }
}
