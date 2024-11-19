package com.quest.oops.bank;

public class CurrentAccount extends BankAccount
{
    private final double OVERDRAFT_LIMIT;

    public CurrentAccount(int accountNumber, String accountHolderName, double balance, double overdraftLimit)
    {
        super(accountNumber, accountHolderName, balance);
        this.OVERDRAFT_LIMIT = overdraftLimit;
    }

    public void withdraw(double amount)
    {
        double balanceCheck=getBalance()-amount;
        if(balanceCheck>= -OVERDRAFT_LIMIT)
        {
            setBalance(balanceCheck);
            System.out.println("Rs"+amount+" withdrawn successfully.");
        }
        else
        {
            System.out.println("Amount exceeds overdraft limit (Rs"+OVERDRAFT_LIMIT+")");
        }
    }

    @Override
    public void displayAccountDetails()
    {
        super.displayAccountDetails();
        System.out.println("Overdraft limit : Rs"+OVERDRAFT_LIMIT);
    }
}
