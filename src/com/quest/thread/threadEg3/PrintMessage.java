package com.quest.thread.threadEg3;

public class PrintMessage implements Runnable
{
    private String message;

    public PrintMessage(String message)
    {
        this.message = message;
    }

    @Override
    public void run()
    {
        try
        {
            Thread.sleep(500);
            System.out.println(message);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
