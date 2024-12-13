package com.quest.useCase.TicketBooking;

public class BookingT extends Thread
{
    private TicketBookingSystem tbs;
    private int userId;

    public BookingT(TicketBookingSystem tbs, int userId) {
        this.tbs = tbs;
        this.userId = userId;
    }

    @Override
    public void run()
    {
        tbs.bookTicket(userId); //book a ticket for user
    }

}
