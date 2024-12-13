package com.quest.useCase.bankTransaction;

import java.util.LinkedList;
import java.util.Queue;

public class BankAccount
{
    private int accNo;
    private int balance;
    private Queue<String> transactionLog;

    public BankAccount(int accNo, int balance) {
        this.accNo = accNo;
        this.balance = balance;
        this.transactionLog=new LinkedList<>();
    }

    public int getAccNo() {
        return accNo;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Queue<String> getTransactionLog() {
        return transactionLog;
    }

    public void setTransactionLog(Queue<String> transactionLog) {
        this.transactionLog = transactionLog;
    }

    public synchronized void deposit(int amount)
    {
        System.out.println("\nattempting to deposit "+amount);
        balance+=amount;
        System.out.println("updated balance : "+balance);
        String transaction="deposited "+amount+", new balance is "+balance;
        transactionLog.add(transaction);
    }

    public synchronized void withdraw(int amount)
    {
        String transaction;
        System.out.println("\nattempting to withdraw "+amount);
        if(balance<amount)
        {
            System.out.println("Insufficient balance, cannot withdraw!");
            System.out.println("Balance : "+balance);
        }
        else
        {
            balance-=amount;
            System.out.println("Updated balance : "+balance);
            transaction="withdrew "+amount+", updated balance is "+balance;
            transactionLog.add(transaction);
        }
    }
}
