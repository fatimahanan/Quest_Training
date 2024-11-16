package com.quest.oops.inheritance;

public class Person
{
    String name;
    int age;
    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
    public void nameAgeDisplay()
    {
        String msg=String.format("Name: %s\nAge: %d", name, age);
        System.out.println(msg);
    }

}
