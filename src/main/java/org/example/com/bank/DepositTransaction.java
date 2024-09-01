package org.example.com.bank;

public class DepositTransaction implements Transaction {
    private Account account;
    private double amount;

    public DepositTransaction(Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        account.deposit(amount);
    }
}
