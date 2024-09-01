package org.example.com.bank;


public class SavingsAccount extends Account {

    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }
    @Override
    public boolean withdraw(double amount) {
        // Withdrawal rules for savings account
        if (amount <= 1000) {
            return super.withdraw(amount);
        }
        return false;
    }
}
