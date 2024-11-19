package com.quest.oops.bank;

public class SavingsAccount extends BankAccount
{
    public final double MIN_BALANCE;

    public SavingsAccount(int accountNumber, String accountHolderName, double balance, double MIN_BALANCE)
    {
        super(accountNumber, accountHolderName, balance);
        this.MIN_BALANCE = MIN_BALANCE;
    }

    public void withdraw(double amount)
    {
        double balanceCheck=getBalance()-amount;
        if(balanceCheck>=MIN_BALANCE)
        {
            setBalance(balanceCheck);
            System.out.println("Rs"+amount+" withdrawn successfully");
        }
        else
            System.out.println("Withdrawal unsuccessful. Minimum balance of Rs"+MIN_BALANCE+" must be maintained");
    }

    @Override
    public void displayAccountDetails()
    {
        super.displayAccountDetails();
        System.out.println("Minimum balance: Rs"+MIN_BALANCE);
    }

}
