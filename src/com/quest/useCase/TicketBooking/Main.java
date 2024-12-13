package com.quest.useCase.TicketBooking;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        TicketBookingSystem tbs=new TicketBookingSystem(5);
        List<Thread> userList=new ArrayList<>();
        for(int i=1;i<=7;i++)
        {
            BookingT userT=new BookingT(tbs,i);
            userList.add(userT);
            try
            {
                userT.start();
                userT.join();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println("\nlog :");
        for(String log:tbs.getLog())
        {
            System.out.println(log);
        }
    }
}
