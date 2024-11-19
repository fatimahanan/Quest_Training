package com.quest.oops.bank;

public class Withdraw extends Transaction
{
    public Withdraw(BankAccount account)
    {
        super(account);
    }

    @Override
    public void processTransaction(double amount)
    {
        if(amount<0)
        {
            System.out.println("Invalid input! Withdrawal amount must be positive");
            return;
        }
        account.withdraw(amount);
    }
}
