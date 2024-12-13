package com.quest.useCase.TicketBooking;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

//Use Case Question 5: Multi-threaded Ticket Booking System
//You are building a ticket booking system where multiple users (threads) book tickets for an event. The tickets are stored in a thread-safe collection.
//
//Requirements:
//        -------------
//        1. Create a TicketBookingSystem class:
//a. Use a ConcurrentLinkedQueue<Integer> to represent available ticket IDs.
//b. Use a thread-safe collection (like CopyOnWriteArrayList) to store booked ticket details for audit purposes.
//        2. Implement a method bookTicket(int userId) that:
//a. Removes a ticket ID from the queue and assigns it to the user.
//b. Logs the booking in the audit list with details like userId and ticketId.
//	3. Simulate multiple threads representing users trying to book tickets concurrently.
//
//Expected Behavior:
//        ------------------
//        1. Tickets are booked in FIFO order.
//        2. No two users can book the same ticket.
//        3. Log the successful bookings.
public class TicketBookingSystem
{
    private Queue<Integer> availableTickets; //available ticket id
    private CopyOnWriteArrayList<String> bookedDetails; //store booked tickets details for auditing purposes

    public TicketBookingSystem(int tickets)  //populating the queue acc to number of tickets
    {
        this.availableTickets = new LinkedList<>();
        this.bookedDetails = new CopyOnWriteArrayList<>();
        for(int i=1;i<=tickets;i++)
        {
            availableTickets.add(i);
        }
    }

    public Queue<Integer> getAvailableTickets() {
        return availableTickets;
    }

    public void setAvailableTickets(Queue<Integer> availableTickets) {
        this.availableTickets = availableTickets;
    }

    public CopyOnWriteArrayList<String> getBookedDetails() {
        return bookedDetails;
    }

    public void setBookedDetails(CopyOnWriteArrayList<String> bookedDetails) {
        this.bookedDetails = bookedDetails;
    }

    // Method to book a ticket
    public synchronized void bookTicket(int userId) {
        Integer ticketId = availableTickets.poll();  // poll ticket id

        if (ticketId != null) {
            String log = "user"+userId+" booked ticket "+ticketId;
            bookedDetails.add(log);  // Log the booking in the audit list
            System.out.println(log);
        }
        else
        {
            System.out.println("user"+userId+" attempted to book ticket, No tickets available");
        }
    }

    public CopyOnWriteArrayList<String> getLog() {
        return bookedDetails;
    }
}

