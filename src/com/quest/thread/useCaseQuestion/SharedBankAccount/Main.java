package com.quest.thread.useCaseQuestion.SharedBankAccount;

public class Main
{
    public static void main(String[] args) {
        BankAccount acc=new BankAccount(500);
        Thread accHolder1=new Thread(()->
        {
            acc.withdraw(300);
            acc.deposit(200);
        });
        Thread accHolder2=new Thread(()->
        {
            acc.withdraw(200);
            acc.withdraw(300);
            acc.deposit(800);
        });
        accHolder1.start();
        accHolder2.start();
    }
}
