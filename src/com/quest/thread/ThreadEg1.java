package com.quest.thread;

public class ThreadEg1 extends Thread
{
    public static void main(String[] args)
    {
        ThreadEg1 t1 = new ThreadEg1()
        {
            @Override
            public void run()
            {
                System.out.println("Thread printing odd numbers");
                for(int i=1;i<=10;i+=2)
                {
                    System.out.println(i);
                }
            }
        };
        ThreadEg1 t2 = new ThreadEg1()
        {
            @Override
            public void run()
            {
                System.out.println("Thread printing even numbers");
                for(int i=2;i<=10;i+=2)
                {
                    System.out.println(i);
                }
            }
        };
        t1.setPriority(7); //odd - higher priority
        t2.setPriority(2); //even - smaller number less priority (in this ide)
        t1.start();
        t2.start();
    }
}