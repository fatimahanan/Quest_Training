package com.quest.collections.QueueEg;

import java.util.Iterator;
import java.util.PriorityQueue;

public class QueueEg
{
    public static void main(String[] args)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(2);
        pq.add(1);
        pq.add(8);
        pq.add(3);
        pq.add(10);
        pq.add(4);
        pq.add(7);
        pq.add(5);
        QueueEg.display(pq);

        System.out.println("\npeeking : "+pq.peek()); //lifo
        System.out.println("\npoll (delete) : "+pq.poll());
        QueueEg.display(pq);
        System.out.println("\nremove (delete) : "+pq.remove());
        QueueEg.display(pq);
        System.out.println("\noffer 8 (insert) : "+pq.offer(8));
        QueueEg.display(pq);
        System.out.println("\nadd 8 (insert) : "+pq.add(8)); //offer is default
        QueueEg.display(pq);
    }
    private static void display(PriorityQueue<Integer> pq)
    {
        System.out.println("displaying priority queue...");
        Iterator<Integer> it = pq.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
    }
}
