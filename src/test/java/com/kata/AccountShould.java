package com.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class AccountShould {
    private Transactions mockTransactions;
    private Account account;
    private StatementPrinter mockStatementPrinter;

    @BeforeEach void set_up() {
        mockTransactions = mock(Transactions.class);
        mockStatementPrinter = mock(StatementPrinter.class);
        account = new Account(mockTransactions, mockStatementPrinter);
    }

    @Test void
    take_a_deposit_request() {
        account.deposit(1000);
        verify(mockTransactions).addDeposit(1000);
    }

    @Test void
    take_a_withdrawl_request() {
        account.withdraw(500);
        verify(mockTransactions).addWithdrawal(500);
    }

    @Test void
    print_statement() {
        account.deposit(1000);
        account.printStatement();
        verify(mockStatementPrinter).print(anyString());
    }
}
