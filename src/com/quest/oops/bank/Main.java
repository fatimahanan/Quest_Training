package com.quest.oops.bank;

public class Main {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount(1000000, "Hanan", 5000.0, 1000.0);
        System.out.println("Savings Account - ");
        savings.displayAccountDetails();
        /*savings.deposit(2000);
        savings.withdraw(3500);
        savings.displayAccountDetails();
        savings.withdraw(3000);  //below minimum balance
        savings.displayAccountDetails();*/

        System.out.println();

        CurrentAccount current = new CurrentAccount(2002020, "David", 1000, 2.0);
        System.out.println("Current Account -");
        current.displayAccountDetails();
        /*current.deposit(1000);
        current.withdraw(2200);  // within overdraft l
        current.displayAccountDetails();
        current.withdraw(3000);  // exceeds the overdraft l
        current.displayAccountDetails();*/

        System.out.println();

        /*BankAccount normalAccount = new BankAccount(23090022, "lala", 10000.0);
        System.out.println("Bank Account -");
        normalAccount.displayAccountDetails();
        normalAccount.deposit(5000);
        normalAccount.withdraw(2000);
        normalAccount.displayAccountDetails();*/

        Transaction depositT = new Deposit(savings);
        Transaction withdrawT = new Withdraw(current);
        depositT.processTransaction(-2);
        withdrawT.processTransaction(-2000);

        System.out.println("\nUpdated details ");
        savings.displayAccountDetails();
        System.out.println();
        current.displayAccountDetails();
    }

}
