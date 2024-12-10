package com.quest.thread.useCaseQuestion.ProducerConsumer;

public class Producer implements Runnable
{
    private final ProducerConsumer list;

    public Producer(ProducerConsumer list)
    {
        this.list =list;
    }


    @Override
    public void run()
    {
        int item=1;
        while(item<=6)
        {
            try
            {
                list.addItem(item);
                item += 1;
//                Thread.sleep(200);
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
