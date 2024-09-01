package org.example.com.bank;


public class WithdrawalTransaction implements Transaction {
    private Account account;
    private double amount;

    public WithdrawalTransaction(Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        account.withdraw(amount);
    }
}
