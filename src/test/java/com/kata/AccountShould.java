package com.kata;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class AccountShould {
    @Test void
    add_a_deposit_to_account() {
        var mockTransactions = mock(Transactions.class);
        var account = new Account(mockTransactions);
        account.deposit(1000);
        verify(mockTransactions).addDeposit(1000);
    }
}
