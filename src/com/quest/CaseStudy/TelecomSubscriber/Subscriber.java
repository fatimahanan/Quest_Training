package com.quest.CaseStudy.TelecomSubscriber;

import java.io.Serializable;
import java.util.ArrayList;

public class Subscriber implements Serializable
{
    private int id;
    private String name;
    private String phone;
    private String planType;
    private int balance;
    private ArrayList<CallHistory> callHistories;

    public Subscriber(int id, String name, String phone, PlanType planType, int balance)
    {
        try {
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("Name cannot be null or empty.");
            }
            if (phone == null || phone.isEmpty()) {
                throw new IllegalArgumentException("Phone number cannot be null or empty.");
            }
            if (balance < 0) {
                throw new IllegalArgumentException("Balance cannot be negative.");
            }

            this.id = id;
            this.name = name;
            this.phone = phone;
            this.planType = String.valueOf(planType);
            this.balance = balance;
            this.callHistories = new ArrayList<>();
        }
        catch (IllegalArgumentException e)
        {
            System.err.println("Exception : " + e.getMessage());
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public ArrayList<CallHistory> getCallHistories() {
        return callHistories;
    }

    public void setCallHistories(CallHistory callHistories) {
        this.callHistories.add(callHistories);
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", planType='" + planType + '\'' +
                ", balance=" + balance +
                '}';
    }

}
