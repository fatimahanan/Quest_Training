package com.quest.collections.QueueEg;

import java.util.PriorityQueue;

public class Queue2
{
    public static void main(String[] args)
    {
        System.out.println("\nInteger...");
        PriorityQueue<Integer> pq1 =new PriorityQueue<>();
        pq1.add(10);
        pq1.add(20);
        pq1.add(5);
        pq1.add(50);
        pq1.add(40);
        pq1.add(40);
        System.out.println(pq1.peek());
        System.out.println(pq1);

        System.out.println("\nCharacter...");
        PriorityQueue<Character> pq2=new PriorityQueue<>();
        pq2.add('b');
        pq2.add('d');
        pq2.add('a');
        pq2.add('c');
        pq2.add('e');
        System.out.println(pq2.peek());
        System.out.println(pq2);

        System.out.println("\nFloat...");
        PriorityQueue<Float> pq3 =new PriorityQueue<>();
        pq3.add(10.0f);
        pq3.add(40.0f);
        pq3.add(20.0f);
        pq3.add(15.0f);
        System.out.println(pq3.peek());
        System.out.println(pq3);

        System.out.println("\nDouble...");
        PriorityQueue<Double> pq4 =new PriorityQueue<>();
        pq4.add(10.0);
        pq4.add(20.0);
        pq4.add(4.2);
        pq4.add(30.0);
        pq4.add(4.4);
        System.out.println(pq4.peek());
        System.out.println(pq4);

        System.out.println("\nLong...");
        PriorityQueue<Long> pq5 =new PriorityQueue<>();
        pq5.add(3L);
        pq5.add(4L);
        pq5.add(1L);
        pq5.add(5L);
        pq5.add(2L);
        System.out.println(pq5.peek());
        System.out.println(pq5);

        System.out.println("\nBoolean...");
        PriorityQueue<Boolean> pq6 =new PriorityQueue<>();
        pq6.add(true);
        pq6.add(false);
        System.out.println(pq6.peek());
        System.out.println(pq6);

        System.out.println("\nShort...");
        PriorityQueue<Short> pq7 =new PriorityQueue<>();
        pq7.add((short) 4);
        pq7.add((short) 2);
        pq7.add((short) 5);
        pq7.add((short) 1);
        pq7.add((short) 3);
        System.out.println(pq7.peek());
        System.out.println(pq7);

        System.out.println("\nByte...");
        PriorityQueue<Byte> pq8 =new PriorityQueue<>();
        pq8.add((byte) 4);
        pq8.add((byte) 2);
        pq8.add((byte) 5);
        pq8.add((byte) 1);
        pq8.add((byte) 3);
        System.out.println(pq8.peek());
        System.out.println(pq8);

    }

}
