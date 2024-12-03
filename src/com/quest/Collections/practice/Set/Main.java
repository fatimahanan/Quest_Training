package com.quest.Collections.practice.Set;

import java.util.HashSet;

public class Main
{
    public static void main(String[] args)
    {
        HashSet<Student> hs1=new HashSet<>();
        hs1.add(new Student(1,"hanan"));
        hs1.add(new Student(2,"pooja"));
        hs1.add(new Student(3,"tyler"));
        System.out.println("set 1 : "+hs1);
        HashSet<Student> hs2=new HashSet<>();
        hs2.add(new Student(1,"hanan"));
        hs2.add(new Student(2,"pooja"));
        System.out.println("set 2 : "+hs2);
        System.out.println("does set 1 contain set 2 ? : "+hs1.containsAll(hs2));
    }
}
