package com.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class AccountShould {
    private Transactions mockTransactions;
    private Account account;
    private StatementPrinter statementPrinter;

    @BeforeEach void set_up() {
        mockTransactions = mock(Transactions.class);
        statementPrinter = mock(StatementPrinter.class);
        account = new Account(mockTransactions, statementPrinter);
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
        var expected = "Date       || Amount || Balance\n" +
            "10/01/2020 || 1000   || 1000";
        account.printStatement();
        verify(statementPrinter).print(new StringBuilder(expected));
    }
}
