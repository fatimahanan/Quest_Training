package com.quest.CaseStudy.TelecomSubscriber;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static java.lang.System.out;

public class SubscriberOperationsImpl implements SubsciberOperations {
    ArrayList<Subscriber> subscribers;
    private static final File file = new File("subscribers.ser");

    public SubscriberOperationsImpl() {
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void addSubscriber(int id, String name, String phone, PlanType planType, int balance) {
        Subscriber subscriber = new Subscriber(id, name, phone, planType, balance);
        subscribers.add(subscriber);
    }

    @Override
    public void updateSubscriberBalancePrepaid(int id, int newBalance) {
        for (Subscriber subscriber : subscribers) {
            if (subscriber.getId() == id && subscriber.getPlanType().equalsIgnoreCase("prepaid")) {
                subscriber.setBalance(newBalance);
                out.println("\nBalance updated for subscriber (" + subscriber.getName() + " to : " + subscriber.getBalance());
                return;
            }
        }
        out.println("Error! Subscriber not found or subscriber uses postpaid...");
    }

    @Override
    public void ListAllSubscribers() {
        if (subscribers.isEmpty()) {
            out.println("Error! Subscriber list is empty!");
        }
        else {
            for (Subscriber subscriber : subscribers) {
                System.out.println(subscriber);
            }
        }
    }

    @Override
    public void recordCallHistory(int id, CallType callType, int durationInMinutes, LocalDateTime timestamp) {
        for (Subscriber subscriber : subscribers)
        {
            if (subscriber.getId() == id) {
                CallHistory callHistory = new CallHistory(callType, durationInMinutes, timestamp);
                subscriber.setCallHistories(callHistory);
                out.println("Calls recorded for " + subscriber.getId());
                return;
            }
        }
        out.println("Error! Subscriber not found!");
    }

    @Override
    public void displayCallHistory(int id) {
        for (Subscriber subscriber : subscribers) {
            if (subscriber.getId() == id) {
                out.println("Call history of " + subscriber.getId() + " (" + subscriber.getName() + ") : ");
                for (CallHistory call : subscriber.getCallHistories()) {
                    out.println(call);
                }
                return;
            }
        }
        out.println("Error! Subscriber not found!");
    }

    @Override
    public void generateBillPostpaid(int id) {
        int total = 0;
        for (Subscriber subscriber : subscribers) {
            if (subscriber.getId() == id && subscriber.getPlanType().equalsIgnoreCase("postpaid")) {
                for (CallHistory call : subscriber.getCallHistories()) {
                    int duration = call.getDurationInMinutes();
                    if (call.getCallType().name().equalsIgnoreCase("local"))
                        total += duration;
                    else if (call.getCallType().name().equalsIgnoreCase("std"))
                        total += duration * 2;
                    else if (call.getCallType().name().equalsIgnoreCase("isd"))
                        total += duration * 5;
                    else {
                        out.println("Error! Invalid call type!");
                        return;
                    }
                }
                out.println("Bill generated for " + subscriber.getId() + " (" + subscriber.getName() + ") : Rs " + total);
                return;
            }
        }

        out.println("Error! Subscriber not found OR not a postpaid subscriber");
    }

    @Override
    public void removeSubscriber(int id)
    {
        for(Subscriber subscriber : subscribers)
        {
            if(subscriber.getId() == id)
            {
                subscribers.remove(subscriber);
                System.out.println("Subscriber "+subscriber.getId()+" removed");
                return;
            }
        }
        System.out.println("Error! Subscriber not found!");
    }

    @Override
    public void saveData()
    {
        if (!file.exists())
        {
            try {
                file.createNewFile();
            } catch (IOException e) {
                out.println("Exception : " + e.getMessage());
            }
        }

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(subscribers);  // Serialize the subscribers list
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            out.println("Error saving data: " + e.getMessage());
        }
    }
    @Override
    public void loadData()
    {
        if (file.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                subscribers = (ArrayList<Subscriber>) in.readObject();
                System.out.println("Data loaded successfully.");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error loading data: " + e.getMessage());
            }
        } else {
            System.out.println("Data file not found.");
        }
    }
}

