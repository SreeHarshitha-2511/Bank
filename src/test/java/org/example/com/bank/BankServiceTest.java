package org.example.com.bank;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankServiceTest {
    private BankService bankService;
    private Account savingsAccount;
    private Account checkingAccount;

    @BeforeEach
    public void setup() {
        bankService = new BankService();
        savingsAccount = new SavingsAccount("SA123", 1000);
        checkingAccount = new CheckingAccount("CA123", 2000);
        bankService.addAccount(savingsAccount);
        bankService.addAccount(checkingAccount);
    }

    @Test
    public void testDeposit() {
        Transaction deposit = new DepositTransaction(savingsAccount, 500);
        bankService.processTransaction(deposit);
        assertEquals(1500, savingsAccount.getBalance());
    }

    @Test
    public void testWithdraw() {
        Transaction withdrawal = new WithdrawalTransaction(checkingAccount, 300);
        bankService.processTransaction(withdrawal);
        assertEquals(1700, checkingAccount.getBalance());
    }

    @Test
    public void testTransfer() {
        Transaction transfer = new TransferTransaction(checkingAccount, savingsAccount, 200);
        bankService.processTransaction(transfer);
        assertEquals(1200, savingsAccount.getBalance());
        assertEquals(1800, checkingAccount.getBalance());
    }

    @Test
    public void testInvalidWithdraw() {
        Transaction withdrawal = new WithdrawalTransaction(savingsAccount, 1500);
        bankService.processTransaction(withdrawal);
        assertEquals(1000, savingsAccount.getBalance()); // Should not change due to withdrawal limit
    }
}
