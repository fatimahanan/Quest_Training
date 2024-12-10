package com.quest.thread.useCaseQuestion.ProducerConsumer;

public class Consumer implements Runnable
{
    private final ProducerConsumer list;

    public Consumer(ProducerConsumer list)
    {
        this.list =list;
    }


    @Override
    public void run()
    {
        int max=5;
        while(max<=5)
        {
            try
            {
                list.removeItem();
//                Thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
                e.printStackTrace();
                break;
            }
        }
    }
}
