package com.quest.thread.threadEg3;

public class ThreadEg3
{
    public static void main(String[] args)
    {
        PrintMessage r1=new PrintMessage("hello");
        PrintMessage r2=new PrintMessage("world");
        PrintMessage r3=new PrintMessage("!");
        Thread t1=new Thread(r1);
        Thread t2=new Thread(r2);
        Thread t3=new Thread(r3);
        try
        {
            t1.start();
            t1.join(); //t1 finishes before t2 starts

            t2.start();
            t2.join(); //t2 finishes before t3 starts gi

            t3.start();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }


    }
}
