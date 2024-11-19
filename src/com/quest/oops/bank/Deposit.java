package com.quest.oops.bank;

public class Deposit extends Transaction
{
    public Deposit(BankAccount account)
    {
        super(account);
    }

    @Override
    public void processTransaction(double amount)
    {
        if(amount<0)
        {
            System.out.println("Invalid input! Deposit amount must be positive");
            return;
        }
        account.deposit(amount);
    }
}
