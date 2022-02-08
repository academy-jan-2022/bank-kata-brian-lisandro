package com.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class AccountShould {
    private TransactionsRepository mockTransactionsRepository;
    private Account account;
    private StatementPrinter mockStatementPrinter;

    @BeforeEach void set_up() {
        mockTransactionsRepository = mock(TransactionsRepository.class);
        mockStatementPrinter = mock(StatementPrinter.class);
        account = new Account(mockTransactionsRepository, mockStatementPrinter);
    }

    @Test void
    take_a_deposit_request() {
        account.deposit(1000);
        verify(mockTransactionsRepository).addDeposit(new Money(1000));
    }

    @Test void
    take_a_withdrawl_request() {
        account.withdraw(500);
        verify(mockTransactionsRepository).addWithdrawal(new Money(-500));
    }

    @Test void
    print_statement() {
        account.deposit(1000);
        account.printStatement();
        verify(mockStatementPrinter).print(anyString());
    }
}
