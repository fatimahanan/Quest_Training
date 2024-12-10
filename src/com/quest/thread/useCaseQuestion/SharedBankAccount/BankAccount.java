package com.quest.thread.useCaseQuestion.SharedBankAccount;

public class BankAccount
{
    int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public synchronized void withdraw(int amount)
    {
        if(balance>=amount)
        {
            balance-=amount;
            System.out.println(Thread.currentThread().getName()+" : withdrew Rs"+amount);
            System.out.println("Updated balance : "+balance);
        }
        else
        {
            System.out.println(Thread.currentThread().getName()+" : Insufficient balance");
            System.out.println("Current balance : "+balance);
        }
    }

    public synchronized void deposit(int amount)
    {
        balance+=amount;
        System.out.println(Thread.currentThread().getName()+" : deposited Rs"+amount);
        System.out.println("Updated balance : "+balance);
    }
}


