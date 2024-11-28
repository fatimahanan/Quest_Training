package com.quest.CaseStudy.TelecomSubscriber;

import java.time.LocalDateTime;

public interface SubsciberOperations
{
    void addSubscriber(int id, String name, String phone, String planType, int balance);
    void updateSubscriberBalancePrepaid(int id, int newBalance);
    void ListAllSubscribers();
    void recordCallHistory(int id, String callType, int durationInMinutes, LocalDateTime timestamp);
    void displayCallHistory(int id);
    void generateBillPostpaid(int id);
//    void saveData();
//    void loadData();
}
