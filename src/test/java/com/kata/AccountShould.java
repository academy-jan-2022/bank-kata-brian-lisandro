package com.kata;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class AccountShould {
    @Test void
    take_a_deposit_request() {
        var mockTransactions = mock(Transactions.class);
        var account = new Account(mockTransactions);
        account.deposit(1000);
        verify(mockTransactions).addDeposit(1000);
    }

    @Test void
    take_a_withdrawl_request() {
        var mockTransactions = mock(Transactions.class);
        var account = new Account(mockTransactions);
        account.withdraw(500);
        verify(mockTransactions).addWithdrawal(500);
    }
}
