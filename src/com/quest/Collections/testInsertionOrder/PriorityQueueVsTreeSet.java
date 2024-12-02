package com.quest.Collections.testInsertionOrder;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class PriorityQueueVsTreeSet
{
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        TreeSet<Integer> ts = new TreeSet<>();
        PriorityQueue<String> pq1 = new PriorityQueue<>();

        pq.add(4);
        pq.add(3);
        pq.add(1);
        pq.add(2);
        pq.add(6);
        pq.add(5);
        pq.add(null);
        pq.add(null);

        ts.add(4);
        ts.add(3);
        ts.add(1);
        ts.add(2);
        ts.add(6);
        ts.add(5);
        ts.add(null);
        ts.add(null);

        pq1.add("a");
        pq1.add("b");
        pq1.add("c");
        pq1.add("d");
        pq1.add(null);
        for (String s:pq1)
        {
            System.out.println(s);
        }


        System.out.println("\nPriority Queue : ");
        pq.forEach(System.out::println);
        System.out.println("\nTree Set : ");
        ts.forEach(System.out::println);
    }
}
