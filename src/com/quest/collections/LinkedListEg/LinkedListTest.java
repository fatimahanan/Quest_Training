package com.quest.collections.LinkedListEg;

import java.util.LinkedList;

public class LinkedListTest
{
    public static void main(String[] args)
    {
        LinkedList<String> list = new LinkedList<>();
        list.add("hanan");
        list.add("shawn");
        list.add("nanu");
        list.add("taylor");
        list.add(3,"rifah");
        list.addFirst("niru");
        list.addLast("ken");
//        list.removeFirst();
//        list.removeLast();
//        list.remove(2);
//        list.clear();
        System.out.println("FIRST NAME : "+list.getFirst());
        System.out.println("LAST NAME : "+list.getLast());
        System.out.println("THIRD NAME : "+list.get(2));
        System.out.println("SIZE : "+list.size());
        System.out.println("\nDISPLAYING ALL NAMES : ");
        for (String s : list)
        {
            System.out.println(s);
        }
        if(!list.isEmpty())
        {
            System.out.println("\nLIST CONTAINS CONTENT");
        }
        String str="nanu";
        if(list.contains(str))
        {
            System.out.println("\nLIST CONTAINS "+str);
        }
        else
        {
            System.out.println("\nLIST DOES NOT CONTAIN "+str);
        }
        System.out.println("\nclearing...");
        list.clear();
        if(list.isEmpty())
        {
            System.out.println("LIST IS EMPTY");
        }
    }
}
