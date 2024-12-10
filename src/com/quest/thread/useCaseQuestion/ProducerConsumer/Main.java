package com.quest.thread.useCaseQuestion.ProducerConsumer;

public class Main
{
    public static void main(String[] args)
    {
        ProducerConsumer list=new ProducerConsumer(5);

        Producer pr=new Producer(list);
        Consumer cr=new Consumer(list);

        Thread pThread=new Thread(pr);
        Thread cThread=new Thread(cr);

        pThread.start();
        cThread.start();

    }
}
