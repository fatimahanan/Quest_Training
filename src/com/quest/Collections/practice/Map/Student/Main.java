package com.quest.Collections.practice.Map.Student;


import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
//        TreeMap<Integer,Student> hm=new TreeMap<>();
//        hm.put(70,new Student(2,"john"));
//        hm.put(90,new Student(3,"jack"));
//        hm.put(100,new Student(1,"jill"));
//
//        for(Map.Entry<Integer, Student> entry:hm.entrySet())
//        {
//            System.out.println(entry.getValue()+" "+entry.getKey());
//        }

        TreeMap<Student,Integer> tm=new TreeMap<>();
        tm.put(new Student(2,"john"),70);
        tm.put(new Student(3,"jack"),90);
        tm.put(new Student(1,"jill"),100);

        ArrayList<Map.Entry<Student,Integer>> list=new ArrayList<>(tm.entrySet());
        list.sort(new marksComparator());

        for(Map.Entry<Student,Integer> entry:list)
        {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

    }
}
