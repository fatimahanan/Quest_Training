package com.quest.thread;

public class ThreadEg2 extends Thread
{
    static int num=1;
    public static void main(String[] args)
    {
        ThreadEg2 t1 = new ThreadEg2()
        {
            @Override
            public void run()
            {
                while (num<=10)
                {
                    if(num%2!=0)
                    {
                        System.out.println(num);
                        num++;
                    }
                }
            }
        };
        ThreadEg2 t2 = new ThreadEg2()
        {
            @Override
            public void run()
            {
                while (num<=10)
                {
                    if(num%2==0)
                    {
                        System.out.println(num);
                        num++;
                    }
                }
            }
        };
        t1.start();
        t2.start();
    }
}
