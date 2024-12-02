package com.quest.Collections.Example.Example2;


import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Main
{
    public static void main(String[] args)
    {
        TreeSet<Student> ts=new TreeSet<>();
        ts.add(new Student(1,"pam",98));
        ts.add(new Student(2,"john",80));
        ts.add(new Student(3,"jane",70));
        ts.add(new Student(4,"tim",100));
        ts.add(new Student(4,"tim",100));
        ts.forEach(System.out::println);
    }
}
