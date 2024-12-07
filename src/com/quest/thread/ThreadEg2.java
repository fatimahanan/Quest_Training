package com.quest.thread;

public class ThreadEg2 extends Thread
{
    static int count=1;
    public static void main(String[] args)
    {
        ThreadEg2 t1 = new ThreadEg2()
        {
            @Override
            public void run()
            {
                while (count<=10)
                {
                    if(count%2!=0)
                    {
                        System.out.println(count);
                        count++;
                    }
                }
            }
        };
        ThreadEg2 t2 = new ThreadEg2()
        {
            @Override
            public void run()
            {
                while (count<=10)
                {
                    if(count%2==0)
                    {
                        System.out.println(count);
                        count++;
                    }
                }
            }
        };
        t1.start();
        t2.start();
    }
}
