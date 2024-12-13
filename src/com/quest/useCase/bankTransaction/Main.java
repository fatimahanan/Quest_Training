package com.quest.useCase.bankTransaction;

public class Main
{
    public static void main(String[] args) {
        BankAccount acc = new BankAccount(123, 100);

        System.out.println("current balance : " + acc.getBalance());
        Thread depositT1 = new Thread(() ->
        {
            acc.deposit(100);
        });

        Thread depositT2 = new Thread(() ->
        {
            acc.deposit(500);
        });

        Thread depositT3 = new Thread(() ->
        {
            acc.deposit(100);
        });

        Thread withdrawT1 = new Thread(() ->
        {
            acc.withdraw(300);
        });

        Thread withdrawT2 = new Thread(() ->
        {
            acc.withdraw(200);
        });
        try
        {
            depositT1.start();
            depositT1.join();
            withdrawT1.start();
            withdrawT1.join();
            depositT2.start();
            depositT2.join();
            withdrawT2.start();
            withdrawT2.join();
            depositT3.start();
            depositT3.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("\nTransaction log : ");
        for(String transaction: acc.getTransactionLog())
        {
            System.out.println(transaction);
        }
    }
}
