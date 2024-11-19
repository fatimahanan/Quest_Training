package com.quest.oops.bank;

public class BankAccount
{
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    BankAccount(int accountNumber, String accountHolderName, double balance)
    {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public int getAccountNumber()
    {
        return accountNumber;
    }

    public String getAccountHolderName()
    {
        return accountHolderName;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setAccountNumber(int accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    public void setAccountHolderName(String accountHolderName)
    {
        this.accountHolderName = accountHolderName;
    }

    public void setBalance(double balance)
    {
        if(balance<0)
            System.out.println("Invalid balance (cannot be 0)");
        else
            this.balance = balance;
    }

    public void displayAccountDetails()
    {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Balance: " + balance);
    }

    public void withdraw(double amount)
    {
        if (amount<=0)
        {
            System.out.println("Invalid input. Withdrawal amount must be positive");
            return;
        }
    }

    public void deposit(double amount)
    {
        if(amount>0)
        {
            balance += amount;
            System.out.println("Rs"+amount+" deposited successfully.");
        }
        else
        {
            System.out.println("Invalid input. Deposit amount must be positive.");
        }
    }

}
