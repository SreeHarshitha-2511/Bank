package org.example.com.bank;

public class TransferTransaction implements Transaction {
    private Account fromAccount;
    private Account toAccount;
    private double amount;

    public TransferTransaction(Account fromAccount, Account toAccount, double amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    @Override
    public void execute() {
        if (fromAccount.withdraw(amount)) {
            toAccount.deposit(amount);
        }
    }
}
