package com.quest.thread.useCaseQuestion.ProducerConsumer;

import java.util.ArrayList;

public class ProducerConsumer
{
    private final int bufferCapacity;
    private ArrayList<Integer> list=new ArrayList<>();

    public ProducerConsumer(int bufferCapacity)
    {
        this.bufferCapacity = bufferCapacity;
        this.list = new ArrayList<>();
    }

    public synchronized void addItem(int item) throws InterruptedException
    {
        while(list.size()==bufferCapacity)
        {
            System.out.println("buffer is full. Producer must wait");
            wait();
        }
        list.add(item);
        System.out.println("producer produced : item"+item);
        notify();
    }

    public synchronized int removeItem() throws InterruptedException
    {
        while(list.isEmpty())
        {
            System.out.println("buffer is empty. Consumer must wait");
            wait();
        }
        int item=list.remove(0);
        System.out.println("consumer consumed : item"+item);
        notify();
        return item;
    }

}
